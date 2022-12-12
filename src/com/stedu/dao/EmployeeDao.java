package com.stedu.dao;

import com.stedu.bean.Employee;
import com.stedu.bean.Page;

public interface EmployeeDao {
    //查询员工个数
    long count();
    //分页查询
    Page<Employee> findByPage(Page<Employee> page);
}
