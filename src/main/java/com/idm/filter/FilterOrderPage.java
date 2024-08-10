package com.idm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/order")
public class FilterOrderPage extends HttpFilter implements Filter {
       
    
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		Long t1 = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long t2 = System.currentTimeMillis();
		System.out.println("time "+ (t2-t1) +"[ms]- url " + httpServletRequest.getRequestURL());
		
	}



}
