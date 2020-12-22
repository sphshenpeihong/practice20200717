package com.sph.practice.mybatis.mapper;

import com.sph.practice.mybatis.pojo.QyUserPO;

/**
 * Created by Shen Peihong on 2020/12/19 20:00
 * Description: 用户Mapper
 *
 * @since 1.0.0
 */
public interface IUserMapper {

    //简单通过id查询user表
    public QyUserPO getUserById(Integer id) throws Exception;

}
