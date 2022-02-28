package com.unicorn.lemis.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2022/2/28 18:03
 * @description 设置编码UTF-8
 */

public class EncodingFilter implements Filter {

    public EncodingFilter(){
        LOGGER.info("过滤器构造");
    }

    public void destroy() {
        LOGGER.info("过滤器 销毁");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding("utf-8");//将编码 改成utf-8
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);

    }

    public void init(FilterConfig arg0) throws ServletException {
        LOGGER.info("过滤器初始化");

    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
