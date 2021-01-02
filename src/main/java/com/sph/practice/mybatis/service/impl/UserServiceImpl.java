package com.sph.practice.mybatis.service.impl;

import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/23 19:49
 * Description:
 *
 * @since 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public QyUserPO getUserById(Integer id) throws Exception {
        return userMapper.getUserById(id);
    }

    @Override
    public List<QyUserPO> getAllUser() {
        return userMapper.getAllUser();
    }
}
