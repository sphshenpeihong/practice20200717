package com.sph.practice.mybatis.test;

import com.sph.practice.mybatis.mapper.IClassMapper;
import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.pojo.QyUserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2020/12/23 16:19
 * Description: 专门负责调用dao层测试
 *
 * @since 1.0.0
 */
@Slf4j
@Component
public class MapperTest {

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
