package com.stedu.service.impl;

import com.stedu.bean.Project;
import com.stedu.dao.EmployeeDao;
import com.stedu.dao.ProjectDao;
import com.stedu.dao.ProjectEmployeeDao;
import com.stedu.dao.impl.EmployeeDaoImpl;
import com.stedu.dao.impl.ProjectDaoImpl;
import com.stedu.dao.impl.ProjectEmployeeDaoImpl;
import com.stedu.service.ProjectService;
import com.stedu.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDao projectDao = new ProjectDaoImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private ProjectEmployeeDao projectEmployeeDao = new ProjectEmployeeDaoImpl();

    @Override
    public List<Project> findAll() {
        List<Project> projectList = null;

        //获取所有的项目
        projectList = projectDao.findAll();
        //为项目添加员工
        for (Project project : projectList) {
            project.setEmps(employeeDao.findByProjectId(project.getPid()));
        }

        return projectList;
    }

    @Override
    public void add(Project project, List<Integer> eids) {
        try {
            JdbcUtil.beginTransaction();
            //添加项目
            long pid = projectDao.add(project);
            //添加项目员工关系
            for (Integer eid : eids) {
                projectEmployeeDao.add((int)pid, eid);
            }
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
    public void del(Integer pid) {
        try {
            JdbcUtil.beginTransaction();
            //删除项目员工关系
            projectEmployeeDao.del(pid);
            //删除项目
            projectDao.del(pid);
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
}
