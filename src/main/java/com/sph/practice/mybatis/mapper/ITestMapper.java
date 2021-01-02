package com.sph.practice.mybatis.mapper;

import com.sph.practice.mybatis.pojo.QyTestPO;

/**
 * Created by Shen Peihong on 2020/12/30 15:47
 * Description:
 *
 * @since 1.0.0
 */
public interface ITestMapper {

    //插入数据与查询数据 关于类型
    void insertData();

    //先查询
    QyTestPO selectData();

}
