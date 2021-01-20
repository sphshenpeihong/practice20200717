package com.sph.practice.mybatis.service.impl;

import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.service.IUserService;
import com.sph.practice.mybatis.vo.Param1VO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> getMapByIds(Map<String, Object> paramMap) throws Exception {
        return userMapper.getMapByIds(paramMap);
    }

    @Override
    public Param1VO selectOne(Integer id) throws Exception {
        return userMapper.selectOne(id);
    }

    @Override
    public Param1VO selectOne1(Integer id) throws Exception {
        return userMapper.selectOne1(id);
    }


}
