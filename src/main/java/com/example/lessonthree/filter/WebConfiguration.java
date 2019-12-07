package com.example.lessonthree.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(filterName = "test",urlPatterns = "/hello/*")
public class WebConfiguration implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------------->Build Filter!!!");
    }

    @Override
    public void destroy() {
        System.out.println("----------------->Destroy Filter!!!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();
        System.out.println("----------------->Filter request adress!!!");
        if (!requestURI.contains("index")){
            System.out.println("------------------>Wrong Adress");
            servletRequest.getRequestDispatcher("/hello/failed").forward(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("------------------>Right Adress");
        }
    }
}
