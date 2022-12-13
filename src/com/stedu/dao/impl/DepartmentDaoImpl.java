package com.stedu.dao.impl;

import com.stedu.bean.Department;
import com.stedu.dao.DepartmentDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public int add(Department department) {
        String sql = "insert into `department`(`dname`, `dlocation`) values(?, ?)";
        Object[] params = {department.getDname(), department.getDlocation()};
        int result = 0;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            result = qr.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Department> findAll() {
        String sql = "select * from `department`";
        List<Department> list = null;
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            list = qr.query(sql, new BeanListHandler<Department>(Department.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Department findByName(String dname) {
        String sql = "select * from `department` where `dname`=?";
        Object[] params = {dname};

        Department department = null;
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            department = qr.query(sql, new BeanHandler<Department>(Department.class), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return department;
    }

    @Override
    public Department findById(String did) {
        String sql = "select * from `department` where `did`=?";
        Object[] params = {did};

        Department department = null;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            department = qr.query(sql, new BeanHandler<Department>(Department.class), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return department;
    }

    @Override
    public int update(Department department) {
        String sql = "update `department` set `dname`=?, `dlocation`=? where `did`=?";
        Object[] params = {department.getDname(), department.getDlocation(), department.getDid()};
        int result = 0;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            result = qr.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
