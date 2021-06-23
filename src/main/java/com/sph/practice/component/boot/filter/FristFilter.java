package com.sph.practice.component.boot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
/*
    urlPatterns：匹配规则
    filterName：过滤器的名字
 */
// @WebFilter(urlPatterns = "/*", filterName = "FristFilter")
@Slf4j
public class FristFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("FristFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("FristFilter doFilter");
        // 过滤器链，转给下一个过滤器继续处理
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("FristFilter destroy");
    }
}
