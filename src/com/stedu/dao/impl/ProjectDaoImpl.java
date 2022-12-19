package com.stedu.dao.impl;

import com.stedu.bean.Project;
import com.stedu.dao.ProjectDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    //查询所有项目
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

    @Override
    public Long add(Project project) throws SQLException {
        String sql = "insert into `project`(`pname`, `pstart`, `pend`, `pprogress`, `pdescription`) values(?, ?, ?, ?, ?)";
        Object[] params = {project.getPname(), new Date(project.getPstart().getTime()), new Date(project.getPend().getTime()), project.getPprogress(), project.getPdescription()};
        int result = 0;

        QueryRunner qr = new QueryRunner();
        //获取插入的主键
        return (Long)qr.insert(JdbcUtil.getConnection(), sql,new ScalarHandler<>(), params);
    }
}
