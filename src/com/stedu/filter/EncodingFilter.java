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

        if(requestURI.contains(".css")||requestURI.contains(".js")) {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");//这样会把CSS文件和JS文件转化为html文件,但是在if中排除了
            filterChain.doFilter(request, response);
        } else {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");//这样会把CSS文件和JS文件转化为html文件,但是在if中排除了
            filterChain.doFilter(request, response);
        }
        //servletRequest.setCharacterEncoding("UTF-8");
        //servletResponse.setContentType("text/html;charset=utf-8");
        //
        //filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
