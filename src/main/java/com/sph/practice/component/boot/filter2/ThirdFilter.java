package com.sph.practice.component.boot.filter2;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
public class ThirdFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("ThirdFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("ThirdFilter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("ThirdFilter destroy");
    }
}
