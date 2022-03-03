package com.sph.practice.component.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * SpringSecurity核心配置雷
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
// @Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private DataSource dataSource;

    // 配置对象，因为Security底层是用该Service对象去操作数据库的，所以需要进行bean的注册
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // 启动时创建表
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 退出
        http.logout().logoutUrl("/security/logout").logoutSuccessUrl("/security/postLogout").permitAll();

        // 配置没有权限访问时，则跳转到自定义页面
        http.exceptionHandling().accessDeniedPage("/html/unauth.html");

        // 表单登录配置
        http.formLogin()
            .loginPage("/html/login.html")      // 登录页面设置（认证页面跳转到自己编写的登录页面）
            .loginProcessingUrl("/security/login")     // 登录访问路径（处理登录逻辑的接口，具体逻辑Security已经帮我们写好了，不需我们自己写，该接口地址必须跟前端的form表单请求接口路径一致）
            .defaultSuccessUrl("/html/success.html").permitAll()     // 登录成功之后，跳转路径
            .and().authorizeRequests()
            .antMatchers("/", "/async/test1").permitAll()       // 设置哪些路径可以直接访问，不需要认证
            .antMatchers("/car/test2.do").hasAuthority("hello")      // 该请求，用户需要具有hello权限才能访问
            .antMatchers("/car/test3.do").hasAnyAuthority("hello,manager")       // 该请求，用户需要具有hello或manager权限就能访问
            .antMatchers("/car/test4.do").hasRole("sale")       // 该请求，用户需要具有sale角色才能访问
            .antMatchers("/car/test5.do").hasAnyRole("gogo,tony")
            .anyRequest().authenticated()       // 所有请求都需身份验证
            .and().rememberMe().tokenRepository(persistentTokenRepository())        // 记住我
            .tokenValiditySeconds(60)   // 过期时长，单位是秒
            .and().csrf().disable();    // 关闭csrf防护
    }

}
