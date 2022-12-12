package com.stedu.dao.impl;

import com.stedu.bean.Admin;
import com.stedu.dao.AdminDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        String sql = "select * from `admin` where `username`=? and `password`=?";
        Object[] params = {username, password};
        Admin admin = null;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

        try {
            admin = qr.query(sql, new BeanHandler<Admin>(Admin.class), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return admin;
    }
}
