package com.stedu.controller;

import com.stedu.bean.Department;
import com.stedu.bean.RespBean;
import com.stedu.service.DepartmentService;
import com.stedu.service.impl.DepartmentServiceImpl;
import com.stedu.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentController", value = "/admin/Department")
public class DepartmentController extends HttpServlet {
    private DepartmentService departmentService = new DepartmentServiceImpl();

    //查询所有
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departmentList = departmentService.findAll();
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功", departmentList));
    }

    //查询所有
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String dname = request.getParameter("dname");
        String dlocation = request.getParameter("dlocation");

        Department department = departmentService.findByName(dname);
        if(department != null) { //部门名重复不允许添加
            JsonUtil.toJSON(response.getOutputStream(), RespBean.error("部门名称重复，添加失败"));
        } else {
            department = new Department(dname, dlocation);
            departmentService.add(department);
            JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("添加成功"));
        }
    }

    //根据ID查询
    protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String did = request.getParameter("did");
        Department department = departmentService.findById(did);
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功",department));
    }

    //根据ID修改
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String didStr = request.getParameter("did");
        Integer did = Integer.parseInt(didStr);
        String dname = request.getParameter("dname");
        String dlocation = request.getParameter("dlocation");

        //创建部门对象
        Department department = new Department(did, dname, dlocation);

        //修改部门
        if(departmentService.update(department) == -1) {
            JsonUtil.toJSON(response.getOutputStream(), RespBean.error("修改之后的名字和其他部门名字重复，请重新命名后修改"));
        } else {
            JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("修改成功"));
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "findAll": //查询所有
                findAll(request, response);
                break;
            case "add": //添加
                add(request, response);
                break;
            case "findById":
                findById(request, response);
                break;
            case "update":
                update(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
