package com.sph.practice.test.markdown.designPattern.proxy;

import com.sph.practice.test.markdown.designPattern.proxy.util.DynamicProxyUtil;
import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/29 14:39
 * Description:客户类
 *
 * @since 1.0.0
 */
public class Client {

    /**
     *
     */
    @Test
    public void test1(){
        ITeacherDao teacherDao = new TeacherDaoImpl();
        ITeacherDao proxy = new TeacherDaoProxy(teacherDao);
        proxy.teach();
        //下面看看获取class里面的一些东西
        //getInterfaces就是拿实现的接口的Class数组
        Class c1 = TeacherDaoImpl.class;
        Class<?>[] interfaces = c1.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }

    /**
     * 获取动态代理对象
     */
    @Test
    public void test2(){
        ITeacherDao teacherDao = new TeacherDaoImpl();
        DynamicProxyUtil proxyUtil = new DynamicProxyUtil<ITeacherDao>(teacherDao);
        //这里需要强转成目标对象的类型
        ITeacherDao proxyInstance = (ITeacherDao)proxyUtil.getProxyInstance();
        proxyInstance.teach();
    }

}
