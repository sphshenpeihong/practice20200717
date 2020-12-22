package com.sph.practice.junit.user;

import com.sph.practice.mybatis.mapper.IClassMapper;
import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.pojo.QyUserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2020/12/19 20:24
 * Description: 测试类
 *
 * @since 1.0.0
 */
@Slf4j
public class UserTest {

    @Resource
    private IUserMapper userMapper;

    @Resource
    private IClassMapper classMapper;

    /**
     *
     */
    @Test
    public void test1(){
        try {
            QyUserPO userById = userMapper.getUserById(1);
            System.out.println(userById);
        } catch (Exception e) {
            log.error("调dao接口异常");
        }
    }

    /**
     *
     */
    @Test
    public void test2(){
        try {
            QyClassPO PO = classMapper.getClassById(1);
            System.out.println(PO);
        } catch (Exception e) {
            log.error("调dao接口异常");
        }
    }

}
