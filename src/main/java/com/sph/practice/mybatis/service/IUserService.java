package com.sph.practice.mybatis.service;

import com.sph.practice.mybatis.pojo.QyUserPO;

import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/23 19:49
 * Description:
 *
 * @since 1.0.0
 */
public interface IUserService {

    //通过Id找用户
    public QyUserPO getUserById(Integer id) throws Exception;

    //查找全部
    public List<QyUserPO> getAllUser();

    //分页查询


}
