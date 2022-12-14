package com.stedu.filter;


import com.stedu.bean.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员资源访问权限的Filter
 */
@WebFilter(value = "/admin/*", dispatcherTypes = {
	DispatcherType.REQUEST,
	DispatcherType.FORWARD,
	DispatcherType.INCLUDE
})
public class LoginFilter implements Filter {

	private FilterConfig config = null;

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		
		if((admin != null)) { //用户已登录
			chain.doFilter(request, response);
		} else { //用户不存在，跳转到管理员登陆页
			resp.sendRedirect(req.getServletContext().getContextPath() +  "/toLogin");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
