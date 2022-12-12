package com.stedu.controller;

import cn.dsna.util.images.ValidateCode;
import com.stedu.bean.Admin;
import com.stedu.bean.RespBean;
import com.stedu.service.AdminService;
import com.stedu.service.impl.AdminServiceImpl;
import com.stedu.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminController", value = {"/login", "/logout", "/verificationCode", "/aaa"})
public class AdminController extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/login": //登录
                login(request, response);
                break;
            case "/logout": //退出
                logout(request,response);
                break;
            case "/verificationCode": //获取验证码
                verificationCode(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    //获取验证码
    protected void verificationCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码
        ValidateCode vc = new ValidateCode(150, 30, 4, 5);
        String verificationCode = vc.getCode();

        //在Session中存储验证码
        request.getSession().setAttribute("verificationCode", verificationCode);
        //将验证码响应给用户
        vc.write(response.getOutputStream());
    }


    //登陆
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verificationCode = request.getParameter("verificationCode");

        //获取Session中的Code
        HttpSession session = request.getSession();
        String sysVerificationCode = (String)session.getAttribute("verificationCode");
        if(sysVerificationCode.equalsIgnoreCase(verificationCode)) {
            Admin admin = adminService.login(username, password);

            if(admin != null) { //登录成功
                session.setAttribute("username", username);
                JsonUtil.toJSON(response.getOutputStream(), RespBean.ok("登录成功"));
            } else { //登录失败信息
                JsonUtil.toJSON(response.getOutputStream(), RespBean.error("登录失败"));
            }
        } else {
            JsonUtil.toJSON(response.getOutputStream(),RespBean.error("验证码输入错误"));
        }
    }

    //退出
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session并让session失效
        request.getSession().invalidate();

        //重定向到登录页
        response.sendRedirect(request.getContextPath() + "/toLogin");
    }
}
