package com.sph.practice.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.google.common.collect.Maps;
import com.sph.practice.mybatisplus.mapper.PlusUserMapper;
import com.sph.practice.mybatisplus.pojo.po.QyPlusUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2021/1/29
 * Description:
 *
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private PlusUserMapper plusUserMapper;

    /**
     * 测试一下测试类
     */
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<QyPlusUser> userList = plusUserMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * int insert(T entity);
     * 单表插入一条数据
     */
    @Test
    public void insertTest() {
        QyPlusUser user = new QyPlusUser("3", 3, "3");
        //允许自己不set进ID，调用insert方法，方法底层会默认使用雪花算法去生成id，并且id也会set到传入的user对象
        //不希望走默认的话，也可以更改传入实体类的主键id生成策略，使用@TableId注解
        int row = plusUserMapper.insert(user); //返回值为影响的行数
        System.out.println(user.getId()); //插入完后会回填主键id的
    }

    /**
     * int deleteById(Serializable id);
     * 删除某条数据（要看具体泛型是什么类型哈，别删错了）
     * 入参声明成Serializable是因为Number类型实现了这个接口，向上转型嗷
     */
    @Test
    public void deleteByIdTest(){
        // 删除某条数据（要看具体泛型是什么类型哈，别删错了）
        // 返回值是影响的条数
        int row = plusUserMapper.deleteById(1354833168517992450L);
    }

    /**
     * int deleteByMap(@Param("cm") Map<String, Object> columnMap);
     * 删除数据，可以在Map添加指定的列与列对应的值
     * 若Map有多个键值对的话，到时候SQL语句是用AND连接条件的
     * 到时候实际是where 指定列名1 = 列值1 AND 指定列名2 = 列值2
     */
    @Test
    public void deleteByMapTest(){
        Map<String, Object> paramMap = Maps.newHashMap();
        // Java类型与数据库字段类型最好匹配(不然存在隐患)
        paramMap.put("name", "3");
        paramMap.put("age", 2);
        int row = plusUserMapper.deleteByMap(paramMap);
        System.out.println(row);
    }



}
