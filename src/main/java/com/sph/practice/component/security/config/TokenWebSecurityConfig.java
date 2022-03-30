package com.sph.practice.component.security.config;

import com.sph.practice.component.security.filter.TokenAuthFilter;
import com.sph.practice.component.security.filter.TokenLoginFilter;
import com.sph.practice.component.security.security.TokenLogoutHandler;
import com.sph.practice.component.security.security.TokenManager;
import com.sph.practice.component.security.security.UnauthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    private UserDetailsService userDetailsService;
    @Resource
    private DataSource dataSource;

    @Autowired
    public TokenWebSecurityConfig(UserDetailsService userDetailsService,
                                  TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.userDetailsService = userDetailsService;
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    // 配置对象，因为Security底层是用该Service对象去操作数据库的，所以需要进行bean的注册
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // 启动时创建表
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    /**
     * 配置设置
     *
     * @param http
     * @throws Exception
     */
    // 设置退出的地址和token，redis操作地址
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
            .authenticationEntryPoint(new UnauthEntryPoint())   // 没有权限访问
            .and().csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and().logout().logoutUrl("/security/logout")    // 退出路径
            .addLogoutHandler(new TokenLogoutHandler(tokenManager, redisTemplate)).and()
            .addFilter(new TokenLoginFilter(tokenManager, redisTemplate, authenticationManager()))
            .addFilter(new TokenAuthFilter(tokenManager, redisTemplate, authenticationManager())).httpBasic();

        // 表单登录配置
        http.formLogin()
            .loginPage("/html/login.html")      // 登录页面设置（认证页面跳转到自己编写的登录页面）
            .loginProcessingUrl("/security/login")     // 登录访问路径（处理登录逻辑的接口，具体逻辑Security已经帮我们写好了，不需我们自己写，该接口地址必须跟前端的form表单请求接口路径一致）
            .defaultSuccessUrl("/html/success.html").permitAll()     // 登录成功之后，跳转路径
            .and().authorizeRequests()
            .and().rememberMe().tokenRepository(persistentTokenRepository())        // 记住我
            .tokenValiditySeconds(60);   // 过期时长，单位是秒

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 调用userDetailsService和密码处理
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // 不进行认证的路径，可以直接访问
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }


}
