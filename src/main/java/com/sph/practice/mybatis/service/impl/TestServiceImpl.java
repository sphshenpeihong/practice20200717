package com.sph.practice.mybatis.service.impl;

import com.google.common.collect.Maps;
import com.sph.practice.mybatis.mapper.ITestMapper;
import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyTestPO;
import com.sph.practice.mybatis.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        /*map.put("id", )
        map.put("date1",)
        map.put("time1",)*/
        testMapper.insertData();
    }

    @Override
    public QyTestPO selectData() {
        return testMapper.selectData();
    }


}
