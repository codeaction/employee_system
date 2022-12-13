package com.stedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 配置字符编码的Filter
 */
@WebFilter(value = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //统一处理请求和响应的乱码
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestURI = request.getRequestURI();

        //设置请求编码
        request.setCharacterEncoding("UTF-8");
        //设置响应编码, 但是要排除css和js
        if(!requestURI.endsWith(".css") && !requestURI.endsWith(".js")) {
            response.setContentType("text/html;charset=UTF-8");
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
