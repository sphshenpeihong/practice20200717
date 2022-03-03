package com.sph.practice.component.security.security;

import cn.hutool.crypto.SecureUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码处理工具类
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Component
public class DefaultPasswordEncoder implements PasswordEncoder {

    // 进行MD5加密
    @Override
    public String encode(CharSequence rawPassword) {
        return SecureUtil.md5(rawPassword.toString());
    }

    // 进行密码比对
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(SecureUtil.md5(rawPassword.toString()));
    }
}
