package com.stedu.service.impl;

import com.stedu.bean.Project;
import com.stedu.dao.EmployeeDao;
import com.stedu.dao.ProjectDao;
import com.stedu.dao.impl.EmployeeDaoImpl;
import com.stedu.dao.impl.ProjectDaoImpl;
import com.stedu.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDao projectDao = new ProjectDaoImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

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
}
