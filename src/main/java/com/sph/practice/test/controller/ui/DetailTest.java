package com.sph.practice.test.controller.ui;

import com.sph.practice.test.controller.bean.ParamBean;
import com.sph.practice.test.controller.ui.param.CacheVO;
import com.sph.practice.test.param.BankVO;
import com.sph.practice.test.param.ResultVO;
import com.sph.practice.test.param.TeacherVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.*;
import java.util.Properties;

/**
 * Created by Shen Peihong on 2020/9/28 18:10
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(path = "/test")
@Slf4j
public class DetailTest {

    @RequestMapping("/test11.do")
    public void test11(@Valid ParamBean paramBean, @Nonnull String ok){
        this.invoke(null);
    }

    private void invoke(@Nonnull String yes){
        System.out.println("123123");
    }



    //注解扫描，执行于此的时候，有static顺带先执行掉了，因为一扫描到类，装载时就立即先执行static块了，获取值是后面的了。

    //使用这种方式去获取配置项的值的话，一定一定不能使用static去声明，因为一旦使用了static声明的变量或方法的话
    //都会在类装载阶段都先赋零值了。
    //引入值
    @Value("${is_open}")
    public boolean isOpen;

    //许多类加了注解，Springboot项目，加了注解，那么tomcat启动的时候，注解扫描的时候，就会去扫描到加了注解的类
    //加了注解的类里面有static静态代码块 或 @PostConstruct声明的方法的话，都会去顺带执行的呢
    /*static {
        System.out.println("1打印is_open" + isOpen);
        log.info("我执行了哈1");
    }*/

    public DetailTest(){
        log.info("看看构造方法是否执行");
    }

    public DetailTest(String username){
        log.info("有参构造，看看是否执行了~~~~");
    }

    @PostConstruct
    void init(){

    }

    //为了只有一台tomcat执行，所以我们特地再加入配置项了。

    /**
     * 测试返回json格式，但是String字符串是重新编码，而不是采用utf-8的编码
     */
    @RequestMapping(path = "/test1.do")
    public ResultVO test1() throws UnsupportedEncodingException {
        System.out.println("我也看看isOpen " + isOpen);
        String s = new String("测试一下".getBytes(), "UTF-8");
        ResultVO resultVO = new ResultVO();
        resultVO.setResult(s);
        return resultVO;
    }

    /**
     * 测试使用阿里的注解
     */
    @RequestMapping(path = "/test2.do")
    public void test2(TeacherVO teacherVO) {
        System.out.println(teacherVO);
    }

    /**
     * 使用@RequestBody 接收Json串
     */
    @RequestMapping(path = "/test3.do")
    public void test3( BankVO bankVO) {
        System.out.println(bankVO);
    }

    /**
     * 若请求参数使用@RequestBody注解声明的话，那么前端必须传json格式的数据，不然后端就会返回400的报错
     */
    @RequestMapping(path = "/test4.do")
    public void test4(@RequestBody String json) {
        System.out.println(json);
    }

    /**
     *
     */
    @GetMapping(path = "/test5.do")
    public void test5() throws IOException {
        Properties properties = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc/jdbc.properties");//获取指向classes目录
        properties.load(is);//指向输入流地址
        String url = properties.getProperty("url");
        System.out.println(url);
        /*
            urlTest
         */
    }

    @PostMapping(path = "/test6.do")
    public Object test6(@RequestBody CacheVO cacheVO) {
        return cacheVO;
    }


}
