package com.stedu.dao;

import com.stedu.bean.Employee;
import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;

import java.util.List;

public interface EmployeeDao {
    //查询员工个数
    long count();
    //分页查询
    Page<EmployeeVo> findByPage(Page<EmployeeVo> page);
    //根据部门ID查询员工
    List<Employee> findByDid(Integer did);
}
