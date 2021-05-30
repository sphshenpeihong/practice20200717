package com.sph.practice.component.boot.filter1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
// 只能匹配/completableFuture开头的(相当于前缀，不能从中间开始匹配)
@WebFilter(urlPatterns = "/completableFuture/*", filterName = "SecondFilter")
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("SecondFilter  init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("SecondFilter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("SecondFilter destroy");

    }
}
