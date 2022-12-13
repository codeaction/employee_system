package com.stedu.service;

import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;

public interface EmployeeService {
    //查询员工个数
    long count();
    //分页查询
    Page<EmployeeVo> findByPage(Page<EmployeeVo> page);
}
