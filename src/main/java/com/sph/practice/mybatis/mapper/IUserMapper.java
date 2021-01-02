package com.sph.practice.mybatis.mapper;

import com.sph.practice.mybatis.pojo.QyUserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/19 20:00
 * Description: 用户Mapper
 *
 * @since 1.0.0
 */
public interface IUserMapper {

    //简单通过id查询user表
    public QyUserPO getUserById(Integer id) throws Exception;

    //查找全部
    public List<QyUserPO> getAllUser();

}
