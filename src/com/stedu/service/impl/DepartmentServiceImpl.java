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
}
