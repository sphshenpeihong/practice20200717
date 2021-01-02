package com.sph.practice.mybatis.service;

import com.sph.practice.mybatis.pojo.QyTestPO;

/**
 * Created by Shen Peihong on 2020/12/30 15:51
 * Description:
 *
 * @since 1.0.0
 */
public interface ITestService {

    void insertData();

    QyTestPO selectData();

}
