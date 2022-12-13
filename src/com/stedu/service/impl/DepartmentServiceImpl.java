package com.stedu.service.impl;

import com.stedu.bean.Department;
import com.stedu.dao.DepartmentDao;
import com.stedu.dao.impl.DepartmentDaoImpl;
import com.stedu.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
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
}
