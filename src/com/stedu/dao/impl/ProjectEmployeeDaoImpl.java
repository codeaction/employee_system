package com.stedu.dao.impl;

import com.stedu.dao.ProjectEmployeeDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class ProjectEmployeeDaoImpl implements ProjectEmployeeDao {
    @Override
    public void add(Integer pid, Integer eid) throws SQLException {
        String sql = "insert into `project_employee`(`pid`, `eid`) values(?, ?)";
        Object[] params = {pid, eid};
        int result = 0;

        QueryRunner qr = new QueryRunner();
        qr.update(JdbcUtil.getConnection(), sql, params);
    }

    @Override
    public void del(Integer pid) throws SQLException {
        String sql = "delete from `project_employee` where `pid`=?";
        Object[] params = {pid};
        int result = 0;

        QueryRunner qr = new QueryRunner();
        qr.update(JdbcUtil.getConnection(), sql, params);
    }
}
