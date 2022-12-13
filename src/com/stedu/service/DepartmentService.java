package com.stedu.service;

import com.stedu.bean.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    int add(Department department);
    Department findByName(String dname);
    Department findById(String did);
    int update(Department department);
}
