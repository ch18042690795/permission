package com.mmall.filter;


import com.mmall.common.RequestHolder;
import com.mmall.model.SysUser;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-06 09:16
 **/
@Slf4j
public class LoginFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        String servletPath = req.getServletPath();

        SysUser user = (SysUser) req.getSession().getAttribute("user");
        if(user == null){
          String path="signin.jsp";
          resp.sendRedirect(path);
          return;
        }
        RequestHolder.add(user);
        RequestHolder.add(req);
        filterChain.doFilter(servletRequest,servletResponse);
        return;
    }

    public void destroy() {

    }
}
