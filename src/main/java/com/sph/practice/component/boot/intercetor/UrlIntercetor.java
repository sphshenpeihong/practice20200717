package com.sph.practice.component.boot.intercetor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
@Configuration
public class UrlIntercetor implements HandlerInterceptor {

    /**
     * 进入controller层之前
     *
     * @param request
     * @param response
     * @param handler
     * @return 是否允许放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("UrlIntercetor preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("UrlIntercetor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("UrlIntercetor afterCompletion");
    }
}
