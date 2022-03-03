package com.sph.practice.component.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyUserPO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private IUserMapper userMapper;

    // 一般这里是获取到页面输入的账号，然后去查询数据库，获取到查询到的账号/密码，然后进行返回
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过查库完成
        QueryWrapper<QyUserPO> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        QyUserPO userPO = userMapper.selectOne(wrapper);
        if (userPO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 当配置角色时，需要加ROLE_前缀，是因为源码会手动帮我们加上前缀，所以我们不得已也得加上...
        List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("hello,ROLE_sale");
        return new User(userPO.getUserName(), new BCryptPasswordEncoder().encode(userPO.getPassword()), grantedAuthorityList);
    }
}
