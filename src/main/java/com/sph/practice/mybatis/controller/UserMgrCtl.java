package com.sph.practice.mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.service.IUserService;
import com.sph.practice.test.sebase.current.ExtendsClass;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    //当前页面第一个元素在数据库中的行号
    private int startRow;
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    //总页数
    private int pages;
    //前一页
    private int prePage;
    //
    private int nextPage;
    //是否为第一页
    private boolean isFirstPage;
    //是否为最后一页
    private boolean isLastPage;
    //是否有前一页
    private boolean hasPreviousPage;
    //是否有下一页
    private boolean hasNextPage;
    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;
    private int navigateFirstPage;
    private int navigateLastPage;

    //今晚再汇总总结一下


}
