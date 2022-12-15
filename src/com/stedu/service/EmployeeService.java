package com.stedu.service;

import com.stedu.bean.Employee;
import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;

public interface EmployeeService {
    //添加
    void add(Employee employee);
    //删除员工
    int chgEstate(Integer eid, Integer estate);
    //查询员工个数
    long count();
    //分页查询
    Page<EmployeeVo> findByPage(Page<EmployeeVo> page);
    //根据员工编号查询员工
    Employee findById(Integer eid);
    //修改员工
    int update(Employee e);
}
