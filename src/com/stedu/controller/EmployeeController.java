package com.stedu.controller;

import com.stedu.bean.Employee;
import com.stedu.bean.Page;
import com.stedu.bean.RespBean;
import com.stedu.service.EmployeeService;
import com.stedu.service.impl.EmployeeServiceImpl;
import com.stedu.utils.JsonUtil;
import com.stedu.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EmployeeController", value = "/admin/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    //分页查询
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String currentPageStr = request.getParameter("currentPage");
        int currentPage = Integer.parseInt(currentPageStr);
        String searchName = request.getParameter("searchName");

        //创建Page对象
        long count = employeeService.count(searchName);
        Page page = PageUtil.createPage(5, (int) count, currentPage);

        page = employeeService.findByPage(page, searchName);
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功", page));
    }

    //添加
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String ename = request.getParameter("ename");
        String eageStr = request.getParameter("eage");
        Integer eage = Integer.parseInt(eageStr);
        String egender = request.getParameter("egender");
        String ejob = request.getParameter("ejob");
        String eentrydateStr = request.getParameter("eentrydate");
        SimpleDateFormat sft = new SimpleDateFormat("yyyy年MM月dd日");
        Date eentrydate = null;
        try {
            eentrydate = sft.parse(eentrydateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String esalaryStr = request.getParameter("esalary");
        Double esalary = Double.parseDouble(esalaryStr);
        String didStr = request.getParameter("did");
        Integer did = Integer.parseInt(didStr);

        Employee employee = new Employee();
        employee.setEname(ename);
        employee.setEage(eage);
        employee.setEgender(egender);
        employee.setEjob(ejob);
        employee.setEentrydate(eentrydate);
        employee.setEsalary(BigDecimal.valueOf(esalary));
        employee.setEstate(1);
        employee.setDid(did);

        employeeService.add(employee);

        JsonUtil.toJSON(response.getOutputStream(),RespBean.ok("添加成功"));
    }

    //删除
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String eidStr = request.getParameter("eid");
        int eid = Integer.parseInt(eidStr);
        employeeService.chgEstate(eid, 0);

        JsonUtil.toJSON(response.getOutputStream(),RespBean.ok());
    }

    //根据员工编号查询
    protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String eidStr = request.getParameter("eid");
        int eid = Integer.parseInt(eidStr);
        Employee employee = employeeService.findById(eid);

        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功", employee));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String eidStr = request.getParameter("eid");
        Long eid = Long.parseLong(eidStr);
        String ename = request.getParameter("ename");
        String eageStr = request.getParameter("eage");
        Integer eage = Integer.parseInt(eageStr);
        String egender = request.getParameter("egender");
        String ejob = request.getParameter("ejob");
        String eentrydateStr = request.getParameter("eentrydate");
        SimpleDateFormat sft = new SimpleDateFormat("yyyy年MM月dd日");
        Date eentrydate = null;
        try {
            eentrydate = sft.parse(eentrydateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String esalaryStr = request.getParameter("esalary");
        Double esalary = Double.parseDouble(esalaryStr);
        String didStr = request.getParameter("did");
        Integer did = Integer.parseInt(didStr);

        Employee employee = new Employee();
        employee.setEid(eid);
        employee.setEname(ename);
        employee.setEage(eage);
        employee.setEgender(egender);
        employee.setEjob(ejob);
        employee.setEentrydate(eentrydate);
        employee.setEsalary(BigDecimal.valueOf(esalary));
        employee.setEstate(1);
        employee.setDid(did);

        employeeService.update(employee);
        JsonUtil.toJSON(response.getOutputStream(),RespBean.ok());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "findByPage":
                findByPage(request,response);
                break;
            case "add":
                add(request,response);
                break;
            case "del":
                del(request, response);
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
