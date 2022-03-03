package com.sph.practice.component.security.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Token工具类（生成token、解析token）
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Component
public class TokenManager {

    // token有效时长
    private long tokenExpiration = 24 * 60 * 60 * 1000;

    // 对称加密密钥
    private String tokenSignKey = "123456";

    // 1、使用jwt根据用户名生成token
    public String createToken(String username) {
        return Jwts.builder().setSubject(username)
                   .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                   .signWith(SignatureAlgorithm.ES512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
    }

    // 2、根据token字符串得到用户信息
    public String getUserInfoByToken(String token) {
        return Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
    }

    // 3、删除token
    public void removeToken(String token) {}


}
