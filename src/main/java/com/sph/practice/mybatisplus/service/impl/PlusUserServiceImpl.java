package com.sph.practice.mybatisplus.service.impl;

import com.sph.practice.mybatisplus.mapper.PlusUserMapper;
import com.sph.practice.mybatisplus.pojo.po.QyPlusUserPO;
import com.sph.practice.mybatisplus.service.IPlusUserService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Shen Peihong on 2021/1/26
 * Description:
 *
 * @since 1.0.0
 */
@Service("plusUserService")
public class PlusUserServiceImpl implements IPlusUserService {

    @Autowired
    private PlusUserMapper plusUserMapper;


    @Override
    public void mpTest() {
        System.out.println(("----- selectAll method test ------"));
        List<QyPlusUserPO> qyPlusUserPOList = plusUserMapper.selectList(null);
        Assert.assertEquals(5, qyPlusUserPOList.size());
        qyPlusUserPOList.forEach(System.out::println);
    }
}

