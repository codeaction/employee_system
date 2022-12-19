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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(name = "ProjectController", value = "/admin/project")
public class ProjectController extends HttpServlet {
    private ProjectService projectService = new ProjectServiceImpl();

    //查询所有
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Project> projectList = projectService.findAll();
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("查询成功",projectList));
    }

    //添加项目
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sft = new SimpleDateFormat("yyyy年MM月dd日");
        //获取请求参数
        String pname = request.getParameter("pname");
        String pstartStr = request.getParameter("pstart");
        String pendStr = request.getParameter("pend");
        Date pstart = null;
        Date pend = null;
        try {
            pstart = sft.parse(pstartStr);
            pend = sft.parse(pendStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String pprogressStr = request.getParameter("pprogress");
        int pprogress = Integer.parseInt(pprogressStr);
        String pdescription = request.getParameter("pdescription");
        String[] eidsStr = request.getParameterValues("eids[]");
        List<Integer> eids= Stream.of(eidsStr).map(Integer::parseInt).collect(Collectors.toList());

        //创建项目对象
        Project project = new Project(pname, pstart, pend, pprogress, pdescription);
        //添加项目及项目员工关系
        projectService.add(project, eids);
        //返回数据
        JsonUtil.toJSON(response.getOutputStream(),RespBean.ok("添加成功"));
    }

    //删除项目
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String pidStr = request.getParameter("pid");
        Integer pid = Integer.parseInt(pidStr);
        //删除项目
        projectService.del(pid);
        //返回数据
        JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("删除成功"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "findAll":
                findAll(request, response);
                break;
            case "add":
                add(request,response);
                break;
            case "del":
                del(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
