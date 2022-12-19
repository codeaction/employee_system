package com.stedu.service.impl;

import com.stedu.bean.Department;
import com.stedu.bean.Employee;
import com.stedu.dao.DepartmentDao;
import com.stedu.dao.EmployeeDao;
import com.stedu.dao.impl.DepartmentDaoImpl;
import com.stedu.dao.impl.EmployeeDaoImpl;
import com.stedu.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<Department> findAllWithEmployee() {
        //查询所有部门
        List<Department> departmentList = departmentDao.findAll();
        departmentList = departmentList.stream()
                .map(item -> {
                    //查询部门对应的员工
                    List<Employee> emps = employeeDao.findByDid(item.getDid());
                    //去除离职员工
                    emps = emps.stream()
                            .filter(emp -> emp.getEstate() == 1)
                            .collect(Collectors.toList());
                    item.setEmps(emps);
                    return item;
                }).filter(item -> item.getEmps().size() > 0).collect(Collectors.toList());
        return departmentList;
    }

    @Override
    public int add(Department department) {
        return departmentDao.add(department);
    }

    @Override
    public Department findByName(String dname) {
        return departmentDao.findByName(dname);
    }

    @Override
    public Department findById(String did) {
        return departmentDao.findById(did);
    }

    @Override
    public int update(Department department) {
        //判断修改之后的名字是否和其他项的名字相同
        Department d = departmentDao.findByName(department.getDname());
        if(d != null && d.getDid() != department.getDid()) {
            return -1;
        }

        return departmentDao.update(department);
    }

    @Override
    public int del(Integer did) {
        List<Employee> employeeList = employeeDao.findByDid(did);
        if(employeeList.size() > 0) {
            return -1;
        }

        return departmentDao.del(did);
    }
}
