package com.sph.practice.test.sebase;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sph.practice.component.boot.resp.Response;
import com.sph.practice.mybatis.vo.ClassVO;
import com.sph.practice.test.controller.bean.ValidDTO;
import com.sph.practice.test.controller.service.InvokeServiceImpl;
import com.sph.practice.test.param.BankVO;
import com.sph.practice.test.param.FieldVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/26 16:06
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/change1")
public class Change1 {

    @GetMapping("/acceptList.do")
    public String acceptList(@RequestBody ClassVO classVO) {
        // 参数解析器
        return JSON.toJSONString(classVO);
    }

    @GetMapping("/acceptList5.do")
    public String acceptList5(@RequestBody ClassVO classVO) {
        return JSON.toJSONString(classVO);
    }

    @GetMapping("/acceptList3.do")
    public String acceptList3(String classVO) {
        return JSON.toJSONString(classVO);
    }

    public Response respAny() {
        Response response = new Response();
        ValidDTO validDTO = new ValidDTO();
        response.setData(validDTO);
        return response;
    }

    @GetMapping("/acceptList2.do")
    public String acceptList(String str) {
        ClassVO classVO = JSON.parseObject(str, ClassVO.class);


        return JSON.toJSONString(classVO);
    }

    /**
     *
     */
    @Test
    public void tes13t(){
        ArrayList<Object> objects = Lists.newArrayList();
        objects.add(null);
    }


    @Autowired
    private InvokeServiceImpl invokeService;

    //定义String字符串
    String username = "123";

    //定义一个final变量
    final int i = 0;

    //Integer是引用类型，主要是尝试一下 把Integer的值set到一个对象中后，那么后面改变原来的 ，会不会影响到set后的
    int j = 0;



    @RequestMapping("/test1.do")
    public void test1(){
        System.out.println(this.username);
        this.username = "456";
        System.out.println(this.i);
    }

    //加载当前类的时候，初始化阶段，识别到这个类有String字符串的话，会把字符串加载到常量池中
    //定义的变量和指向的值都存储在常量池的话，那么当你访问的变量是常量池的变量的话，那么指向的也即是该值了。
    //若进行修改的话，那么其它使用到的地方也会获取到修改之后的值的了

    //为啥其它类 创建对象，然后进行访问还是仍然是初始化时候的值呢、
    //是因为创建对象的话，对象和对象指向的引用都是存储在堆中 ，全新的一份。
    @RequestMapping("/test2.do")
    public void test2(){
        System.out.println(this.username);
    }

    @RequestMapping("/test3.do")
    public void test3(){
        System.out.println(this.j);
        j = 1;
    }

    @RequestMapping("/test4.do")
    public void test4(){
        System.out.println(this.j);
    }

    //这个问题主要取决于SpringMVC中的对象是单例还是多例的问题了

    @RequestMapping("/test5.do")
    public void test5(){
        invokeService.test1();
    }

    @RequestMapping("/test6.do")
    public void test6(){
        invokeService.test2();
    }

    @RequestMapping("/test71.do")
    public void test71(){
        try {
            invokeService.test71();
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    //Spring包括Springmvc的话，创建对象的方式都是单例的呢。默认单例的呢。比方你要调Springmvc的接口的话，那么底层也是先去创建对象，再调
    //而这个创建对象的就是获取同一个单例对象的呢。所以我们开发过程当中，如果你定义常量的话，一定一定一定要用final，不然你不知道它啥时候
    //就被修改了，而这个成员变量被修改，就会影响到其它的呢。我们定义final常量的话，存储地方就是在方法区里面的常量池呢。
    //所以我们工具类定义常量的话，可以直接用static修饰呢。反正都是放在方法区中

    //接下来试试栈 栈里面定义一个int 或 Integer
    /**
     * 试试get set操作
     */
    @Test
    public void test(){
        String[] str = new String[1];

        //操作步骤：先定义一个变量i 基本类型的
        //然后set到一个对象里边，然后我们后面又
        Integer i = 1;
        FieldVO fieldVO = new FieldVO();
        //通过方法传递，这里原来的i是值的话，那么就是值传递，另外方法参数那边
        //是先定义一个变量，copy这个值呢
        //如果是地址传递的话，那么copy的是传递的引用值呢。一改原来的话，那么也会去改动
        //后面使用这个值的值
        //但是呢 Integer这些包装类的话，比较特殊，为啥这么说呢
        //是因为里面的value都是final的话，也就是说后面无论你怎么改，都不会改变的呢
        fieldVO.setId(i);
        System.out.println(fieldVO);
        i = 2;
        System.out.println(fieldVO);
        System.out.println(i);
    }

    /**
     * 定义一个ArrayList 然后初始化值 赋值给某个新的ArrayList 地址复制，相当于指向同一个
     * 然后给原来的ArrayList 赋上 最新的ArrayList  相当于改变的指向 看看第二个会不会影响改变
     */
    @Test
    public void test10(){
        List<String> list1 = Lists.newArrayList("123");
        List<String> list3 = Lists.newArrayList("456");
        //addAll的话是追加 我这里是直接指向了
        List<String> list2 = list1;
        System.out.println("list1：" + list1);
        System.out.println("list2：" + list2);
        //这个时候 list1这个变量改变了指向了 指向list3所指向的呢。原来的list2是依然的呢。
        list1 = list3;
        System.out.println("========");
        System.out.println("list1：" + list1);
        System.out.println("list2：" + list2);
    }

    //原来Integer变量 = 1，然后后面即使你这个Integer变量重新赋值，也不会影响到你之前赋值的那些变量了。

    /**
     *
     */
    @Test
    public void test11(){
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = 1000;
        Integer i4 = 1000;
    }

    /**
     *
     */
    @Test
    public void test12(){
        Integer i = 1;
    }

    /**
     *
     */
    @Test
    public void test13(){
        Integer i = Integer.valueOf(1);
    }


}
