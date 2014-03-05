package edu.nju.healthClub.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 7569192982584071331L;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		
		String contextPath=request.getContextPath();
		String url=request.getServletPath();
		
		String adminUserString = (String) session.getAttribute("adminid");
        if (adminUserString == null && !url.contains("ogin")) {
        	response.sendRedirect(contextPath+"/admin/login.jsp"); 
        	return;
		}
        chain.doFilter(sRequest, sResponse); 
	}

}
