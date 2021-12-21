package com.sph.practice.test.controller.request;

import com.google.common.collect.Lists;
import com.sph.practice.test.bean.AuthVO;
import com.sph.practice.test.param.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Shen Peihong on 2020/10/21 21:16
 * Description:
 *
 * @since 1.0.0
 */
@RequestMapping(value = "/request")
@RestController
@Slf4j
public class RequestCtl {

    private final static Logger crLogger = LoggerFactory.getLogger("asyncBizLoggerAppenderCR");

    @RequestMapping("/test19")
    public void test19(@RequestBody AuthVO authVO) {
        log.info("打印入参，authVO = {}", authVO);
    }

    /**
     * request相关方法测试
     */
    @RequestMapping("/test1.do")
    public void test1(HttpServletRequest request){
        //请求地址：http://localhost:8085/shop/request/test1.do?username=zhangsan
        //1、获取请求参数
        String username = request.getParameter("username");
        System.out.println("username" + " ： " + username);
        //username ： zhangsan

        //2、获取请求的协议
        String scheme = request.getScheme();
        System.out.println("scheme" + " ： " + scheme);
        //scheme ： http

        //3、获取项目前缀
        String contextPath = request.getContextPath();
        System.out.println("contextPath" + " ： " + contextPath);
        //contextPath ： /shop

        //4、获取IP地址、或域名
        String serverName = request.getServerName();
        System.out.println("serverName" + " ： " + serverName);
        //serverName ： localhost

        //5、获取地址后缀(从项目前缀后开始)
        String servletPath = request.getServletPath();
        System.out.println("servletPath" + " ： " + servletPath);
        //servletPath ： /request/test1.do

        //6、获取请求URL
        StringBuffer requestURL = request.getRequestURL();//获取请求URL
        System.out.println("requestURL" + " ： " + requestURL);
        //requestURL ： http://localhost:8085/shop/request/test1.do

        //7、获得头部的某个属性
        String userAgent = request.getHeader("User1-Agent");
        System.out.println("userAgent" + " ： " + userAgent);
        //userAgent ： PostmanRuntime/7.26.5

        //8、获得参数(大多用于复选框)
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println("参数key：" + entry.getKey());
            System.out.println("key对应的value为：");
            for (String str : Lists.newArrayList(entry.getValue())) {
                System.out.println(str);
            }
            System.out.println("---------------分割线---------");
        }
        //由于复选框、或表单数据的name值相同的话，后台参数需要使用数组接收，不能使用getParameter()这个方法去接收呢，下面介绍一个API，可以接收所有前端的请求参数（Map类型）

    }

    /**
     * HttpServletResponse
     * 后端传cookie
     */
    @RequestMapping("/test2.do")
    public void test2(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        //重定向到其它URL (支持拼前面的域名，也支持不拼，不拼的话会默认本机)
        response.sendRedirect(request.getContextPath() + "/request/test1.do?username=222");
        //也支持跳第三方URL
        //response.sendRedirect("https://www.taobao.com");
    }

    /**
     * getSession的三种方式
     */
    @RequestMapping("/test3.do")
    public void test3(HttpServletRequest request){
        /*
            request.getSession(); //从当前request请求中获取session，如果获取不到session，则会自动创建一个session。如果获取到session，则返回获取到的session
            request.getSession(true); 作用同上一样 //只是增加一个true参数，告诉它在获取不到session的情况下自动创建session
            request.getSession(false); 获取不到session的时候，不会自动创建session，而是返回null
         */
        request.getSession(true); //获取不到，则新建一个session对象
    }

    /**
     * 返回时，设置返回头部属性
     */
    @RequestMapping("/test4.do")
    public void test4(HttpServletResponse response){
        String encode = "encode";
        //返回excel需要指定下载的文件名
        response.setHeader("Content-disposition", "attachment; filename=\"" + encode + ".xls" + "\"");
        //声明返回的类型
        response.setHeader("ContentType", "application/msexcel");
    }

    /**
     *
     */
    @RequestMapping("/test5.do")
    public void test5(){
        synchronized (this){
            //lock是对象,可以声明为Object类型,多个线程必须使用同一把锁才有效
            //若是实现Runnable接口，则里面的变量是共享的，不用声明为static
            //如果是继承Thread类的话，那么就需要声明锁为static
            //会产生线程安全问题的代码块
        }
    }

    /**
     *
     */
    @RequestMapping("/test6.do")
    public ResultVO test6(){
        ResultVO resultVO = new ResultVO();
        resultVO.setResult(null);
        return resultVO;
    }

    /**
     *
     */
    @RequestMapping("/test8.do")
    public void test8() throws IOException {
        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("BOOT-INF/classes/banner.txt");
        URL url = resources.nextElement();
        UrlResource resource = new UrlResource(url);
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        System.out.println(properties);
    }

    /**
     *
     */
    @RequestMapping("/test9.do")
    public void test9(@RequestBody Receive2DTO receive2DTO){
        System.out.println("停");
    }

    /**
     *
     */
    @RequestMapping("/test10.do")
    public void test10(){
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("测试1，异常了，e = {}", e);
            log.error("测试2，异常了，", e);
        }
    }

}
