package com.stedu.dao.impl;

import com.stedu.bean.Employee;
import com.stedu.bean.Page;
import com.stedu.dao.EmployeeDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public long count() {
        String sql = "select count(1) from `employee`";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        long count = 0;

        try {
            count = qr.query(sql, new ScalarHandler<Long>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    @Override
    public Page<Employee> findByPage(Page<Employee> page) {
        String sql = "select * from `employee` limit ?, ?";
        Object[] params = {page.getBeginIndex(), page.getEveryPage()};
        List<Employee> list = null;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            list = qr.query(sql, new BeanListHandler<Employee>(Employee.class), params);
            page.setList(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return page;
    }
}