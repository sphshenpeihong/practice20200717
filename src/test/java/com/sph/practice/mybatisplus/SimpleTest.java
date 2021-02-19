package com.sph.practice.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * 1、int insert(T entity);
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
     * 2、int deleteById(Serializable id);
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
     * 3、int deleteByMap(@Param("cm") Map<String, Object> columnMap);
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

    /**
     * 4、int delete(@Param("ew") Wrapper<T> queryWrapper);
     */
    @Test
    public void deleteTest(){

    }

    /**
     * int updateById(@Param("et") T entity);
     */
    @Test
    public void updateTest(){
        //更新主键id为：1354836048880775171 的数据
        QyPlusUser user = new QyPlusUser("3", 3, "3");
        user.setId(1354836048880775173L);
        user.setName("123321");
        int row = plusUserMapper.updateById(user);
        System.out.println(row);
    }

    /**
     * 测试乐观锁，先select，然后执行update的时候，会判断当前乐观锁字段与select时的对比，若不一致，则修改不成功
     */
    @Test
    public void versionTest(){
        QyPlusUser qyPlusUser = plusUserMapper.selectById(1354836048880775173L);
        qyPlusUser.setName("version");
        int row = plusUserMapper.updateById(qyPlusUser);
        System.out.println(row);
    }

    /**
     * 测试乐观锁，
     * 修改完毕后，没及时update，这个时候也被其它线程给update了，那么我慢了一点，还能Update成功吗？
     */
    @Test
    public void versionTest1() {
        QyPlusUser user1 = plusUserMapper.selectById(1354836048880775173L);
        user1.setName("version");

        // 模拟另外一个线程B，在A线程还没update的时候，结果B成功了，A没成功
        // 因为当A执行的时候，判断乐观锁字段版本对不上，所以本次执行update语句失败
        QyPlusUser user2 = plusUserMapper.selectById(1354836048880775173L);
        user2.setName("niubi");
        int row2 = plusUserMapper.updateById(user2);
        System.out.println(row2);

        int row1 = plusUserMapper.updateById(user1);
    }

    /**
     * List<T> selectByMap(@Param("cm") Map<String, Object> columnMap);
     */
    @Test
    public void selectByMapTest() {
        // 用map设置条件查询 多个条件用AND连接
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("email", "3");
        paramMap.put("age", "3");

        List<QyPlusUser> userList = plusUserMapper.selectByMap(paramMap);
        userList.forEach(System.out::println);
    }

    /**
     * Wrapper是底层接口，具体许多条件构造器的方法封装到抽象类AbstractWrapper
     */
    @Test
    public void queryWrapperTest() {
        // 查找年龄大于17岁，名字是J开头的数据
        QueryWrapper<QyPlusUser> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 17);
        wrapper.likeRight("name", "J");

        List<QyPlusUser> userList = plusUserMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    /**
     * Wrapper是底层接口，具体许多条件构造器的方法封装到抽象类AbstractWrapper
     */
    @Test
    public void queryWrapperCountTest() {
        // 查找年龄大于17岁，名字是J开头的数据
        QueryWrapper<QyPlusUser> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 17);
        wrapper.likeRight("name", "J");

        Integer row = plusUserMapper.selectCount(wrapper);
        System.out.println(row);
    }



    /**
     * 试试MP的分页插件
     */
    @Test
    public void pageSelectTest() {
        // 创建分页对象
        IPage<QyPlusUser> page = new Page();
        /*plusUserMapper.selectPage()*/
    }



}
