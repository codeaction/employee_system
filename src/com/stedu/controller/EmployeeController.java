package com.stedu.controller;

import com.stedu.bean.Page;
import com.stedu.bean.RespBean;
import com.stedu.service.EmployeeService;
import com.stedu.service.impl.EmployeeServiceImpl;
import com.stedu.utils.JsonUtil;
import com.stedu.utils.PageUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeController", value = "/admin/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    //分页查询
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String currentPageStr = request.getParameter("currentPage");
        int currentPage = Integer.parseInt(currentPageStr);

        //创建Page对象
        long count = employeeService.count();
        Page page = PageUtil.createPage(5, (int) count, currentPage);

        page = employeeService.findByPage(page);
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功", page));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "findByPage":
                findByPage(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
