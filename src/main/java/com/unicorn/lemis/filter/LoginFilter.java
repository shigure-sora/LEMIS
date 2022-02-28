package com.unicorn.lemis.filter;

import com.unicorn.lemis.entity.LEMIS_User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author kano_dayo
 * @date 2021/2/28 18:03
 * @description 用户未登录返回登录页面
 */

public class LoginFilter implements Filter {

    public void destroy() {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        CIMS_User user = (CIMS_User) request.getSession().getAttribute("user");

        String contextPath = request.getContextPath();

        String uri = request.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/")+1, uri.length());

        if(user != null){
            chain.doFilter(request, response);
        } else{
            response.sendRedirect(contextPath+"/login.html");
        }
    }

    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
