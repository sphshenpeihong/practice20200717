package com.sph.practice.component.security.security;

import com.sph.practice.component.security.model.utils.R;
import com.sph.practice.component.security.model.utils.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未授权统一处理类
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class UnauthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("未授权");
        ResponseUtil.out(response, R.error());
    }
}
