package com.stedu.service.impl;

import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;
import com.stedu.dao.EmployeeDao;
import com.stedu.dao.impl.EmployeeDaoImpl;
import com.stedu.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public long count() {
        return employeeDao.count();
    }

    @Override
    public Page<EmployeeVo> findByPage(Page<EmployeeVo> page) {
        return employeeDao.findByPage(page);
    }
}
