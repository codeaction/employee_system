package com.stedu.dao.impl;

import com.stedu.bean.Project;
import com.stedu.dao.ProjectDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    @Override
    public List<Project> findAll() {
        String sql = "select * from `project`";

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        List<Project> projects = null;
        try {
            projects = qr.query(sql, new BeanListHandler<Project>(Project.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return projects;
    }
}
