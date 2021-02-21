package com.sph.practice.mybatis.service.impl;

import com.google.common.collect.Maps;
import com.sph.practice.mybatis.mapper.ITestMapper;
import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyTestPO;
import com.sph.practice.mybatis.service.ITestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/30 15:51
 * Description:
 *
 * @since 1.0.0
 */
@Service("testService")
public class TestServiceImpl implements ITestService {

    @Resource
    private ITestMapper testMapper;


    @Override
    public void insertData() {
        Map<String, Object> map = Maps.newHashMap();
        //map.put("id", 100);
        map.put("date1", "2021-01-04");
        int i = testMapper.insertData(map);
        System.out.println("打印i ：" + i);
    }

    @Override
    public QyTestPO selectData() {
        return testMapper.selectData();
    }

    @Transactional
    @Override
    public void handleAccount() {
        System.out.println("判断开启事务的时机");
        QyTestPO qyTestPO1 = testMapper.selectData();

        // update语句  调+50的方法
        testMapper.addMoney();


        // select语句  一级缓存
        QyTestPO qyTestPO2 = testMapper.selectData();
        QyTestPO qyTestPO3 = testMapper.selectData();
        QyTestPO qyTestPO4 = testMapper.selectData();

        //int i = 1 / 0;

        // update语句  调-50的方法
        testMapper.reduceMoney();
        System.out.println("判断提交事务的时机");
    }

    @Override
    public int createData(QyTestPO qyTestPO) {
        return testMapper.createData(qyTestPO);
    }


}
