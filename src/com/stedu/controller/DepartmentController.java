package com.stedu.controller;

import com.stedu.bean.Department;
import com.stedu.bean.RespBean;
import com.stedu.service.DepartmentService;
import com.stedu.service.impl.DepartmentServiceImpl;
import com.stedu.utils.JsonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentController", value = "/admin/Department")
public class DepartmentController extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl();

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departmentList = departmentService.findAll();
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功", departmentList));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "findAll": //查询所有
                findAll(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
