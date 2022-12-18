package com.stedu.service.impl;

import com.stedu.bean.Employee;
import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;
import com.stedu.dao.EmployeeDao;
import com.stedu.dao.impl.EmployeeDaoImpl;
import com.stedu.service.EmployeeService;
import com.stedu.utils.JdbcUtil;

import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void add(Employee employee) {
        try {
            JdbcUtil.beginTransaction();
            String maxNo = employeeDao.maxEno();
            maxNo = (Integer.parseInt(maxNo) + 1) + "";
            employee.setEno(maxNo);
            employeeDao.add(employee);
            JdbcUtil.commitTransaction();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                JdbcUtil.rollbackTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int chgEstate(Integer eid, Integer estate) {
        return employeeDao.chgEstate(eid, estate);
    }

    @Override
    public long count(String searchName) {
        return employeeDao.count(searchName);
    }

    @Override
    public Page<EmployeeVo> findByPage(Page<EmployeeVo> page, String searchName) {
        return employeeDao.findByPage(page, searchName);
    }

    @Override
    public Employee findById(Integer eid) {
        return employeeDao.findById(eid);
    }

    @Override
    public int update(Employee e) {
        return employeeDao.update(e);
    }
}
