package com.sph.practice.component.security.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * SpringSecurity用户实体类
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // 微信openid
    private String username;

    // 密码
    private String password;

    // 昵称
    private String nickName;

    // 用户头像
    private String salt;

    // 用户签名
    private String token;

}
