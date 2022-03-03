package com.sph.practice.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sph.practice.mybatisplus.mapper.PlusUserMapper;
import com.sph.practice.mybatisplus.pojo.po.QyPlusUser;
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
public class PlusUserServiceImpl extends ServiceImpl<PlusUserMapper, QyPlusUser> implements IPlusUserService {

    @Autowired
    private PlusUserMapper plusUserMapper;


    @Override
    public void mpTest() {
        System.out.println(("----- selectAll method test ------"));
        List<QyPlusUser> qyPlusUserList = plusUserMapper.selectList(null);
        Assert.assertEquals(5, qyPlusUserList.size());
        qyPlusUserList.forEach(System.out::println);
    }
}

