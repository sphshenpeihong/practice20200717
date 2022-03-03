package com.sph.practice.component.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 默认已经有类（已注册成bean对象）去实现WebSecurityConfigurerAdapter抽象类了
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
// @Configuration
public class SecurityConfig2 extends WebSecurityConfigurerAdapter {

    // Spring Security底层会去注入bean，当需要设置账密的时候，即会调该方法，进行账密设置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("root1");
        auth.inMemoryAuthentication().withUser("root1").password(password).roles("admin");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
