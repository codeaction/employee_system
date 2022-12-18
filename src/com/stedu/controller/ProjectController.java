package com.stedu.controller;

import com.stedu.bean.Project;
import com.stedu.bean.RespBean;
import com.stedu.service.ProjectService;
import com.stedu.service.impl.ProjectServiceImpl;
import com.stedu.utils.JsonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProjectController", value = "/admin/project")
public class ProjectController extends HttpServlet {
    private ProjectService projectService = new ProjectServiceImpl();

    //查询所有
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Project> projectList = projectService.findAll();
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功",projectList));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "findAll":
                findAll(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
