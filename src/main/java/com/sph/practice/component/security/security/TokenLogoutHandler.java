package com.sph.practice.component.security.security;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 登出处理类
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager tokenManager;

    private RedisTemplate redisTemplate;

    public TokenLogoutHandler(TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 1、从header里面获取token
        // 2、token不为空，移除token，从redis删除token
        String token = request.getHeader("token");
        if (Objects.nonNull(token)) {
            // 移除
            tokenManager.removeToken(token);
            // 从token获取用户名
            String username = tokenManager.getUserInfoByToken(token);
            redisTemplate.delete(username);
            System.out.println("删除成功！！！");
        }
    }
}
