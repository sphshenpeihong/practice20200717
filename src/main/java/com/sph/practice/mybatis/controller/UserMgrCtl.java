package com.sph.practice.mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.service.IUserService;
import com.sph.practice.mybatis.vo.Param1VO;
import com.sph.practice.test.sebase.current.ExtendsClass;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/23 19:52
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/user/mgr")
public class UserMgrCtl {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping("/test1.do")
    public void test1(Integer id) throws Exception{
        QyUserPO PO = userService.getUserById(id);
        System.out.println(PO);

    }


    @RequestMapping("/test2.do")
    public void test1() throws Exception{
        //初始化分页对象存放到ThreadLocal里面的Map中
        PageHelper.startPage(4, 2);
        //使用了分页插件的话，那么SQL就不能再去重复写Limit了，因为Mybatis底层也是通过获取ThreadLocal的值
        List<QyUserPO> list = userService.getAllUser();
        //利用PageInfo的构造方法去get到相关值
        //因为使用了分页插件，所以实际查询完毕的实例类型是Page，继承了ArrayList
        //但继承或实现集合相关接口的话，debug是只能看到0、1、2（列表的值），无法看到其它成员变量
        //故重新定义一个PageInfo对象去接收相关的值呢。
        PageInfo<QyUserPO> pageInfo = new PageInfo<>(list, 3);
        System.out.println(pageInfo);
    }

    @RequestMapping("/test3.do")
    public void test3() throws Exception{
        Map<String, Object> paramMap = new HashMap<String, Object>() {
            {
                put("idList", Lists.newArrayList(1));
            }
        };
        Map<String, Object> resultMap = userService.getMapByIds(paramMap);
    }

    @RequestMapping("/test4.do")
    public void test4() throws Exception{
        int i = 1;
        Param1VO VO = userService.selectOne(i);
        System.out.println(VO);
    }

    @RequestMapping("/test5.do")
    public void test5() throws Exception{
        int i = 1;
        Param1VO VO = userService.selectOne1(i);
        System.out.println(VO);
    }

}
