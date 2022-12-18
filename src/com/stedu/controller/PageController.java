package com.stedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 负责页面跳转
 */
@WebServlet(name = "PageController", value = {"/toLogin", "/admin/toIndex", "/admin/toEmployee", "/admin/toDepartment", "/admin/toProject"})
public class PageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/toLogin": //去登陆页
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
                break;
            case "/admin/toIndex": //去首页
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
                break;
            case "/admin/toEmployee": //去员工管理页面
                request.getRequestDispatcher("/WEB-INF/employee.jsp").forward(request,response);
                break;
            case "/admin/toDepartment": //去部门管理页面
                request.getRequestDispatcher("/WEB-INF/department.jsp").forward(request,response);
                break;
            case "/admin/toProject": //去项目管理页面
                request.getRequestDispatcher("/WEB-INF/project.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
