package com.stedu.dao;

import com.stedu.bean.Department;

import java.util.List;

public interface DepartmentDao {
    //添加
    int add(Department department);
    //查询所有
    List<Department> findAll();
    //根据部门名称查询
    Department findByName(String dname);
}
