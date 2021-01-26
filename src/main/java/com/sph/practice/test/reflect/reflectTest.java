package com.sph.practice.test.reflect;

import com.sph.practice.test.bean.User1;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by Shen Peihong on 2020/9/8 10:40
 * Description:反射的使用
 *
 * @since 1.0.0
 */
public class reflectTest {

    /**
     * 生成Class对象的几种方式 并且获取某个类对象的成员变量，并打印出id
     */
    @Test
    public void test() throws Exception {
        User1 u = new User1(1,"zhangsan","123456",-1);

        Class user = User1.class;
        Class user1 = Class.forName("com.sph.practice.test.bean.User1");
        Field id = user1.getDeclaredField("id");
        id.setAccessible(true);
        System.out.println(id.get(u));
    }

    /**
     *
     */
    @Test
    public void test1(){
        User1 user1 = (User1) this.reflectMethod(User1.class);
        System.out.println(user1);
    }

    /**
     * 定义一个泛型方法，入参必须是Class<T> 返回值是T的话，必须使用<T>进行声明
     * @param c 入参Class对象
     * @param <T> 声明一个泛型
     * @return
     */
    private <T extends User1> T reflectMethod(Class<T> c){
        try {
            T t = c.newInstance();
            return t;
        } catch (Exception e) {
            System.out.println("进行实例化失败");
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {

        //获取Class对象
        //1，通过对象来获取.class对象
        User1 u1 = new User1();
        Class c1 = u1.getClass();  //获取一个类的.class对象的一种方法

        reflectTest d1 = new reflectTest();
        Class c2 = d1.getClass();

        System.out.println(c1==c2);

        //2，通过类来获取.class对象
        Class c3 = User1.class;
        Class c4 = User1.class;
        System.out.println(c1==c4);

        //3，通过Class类里面的静态方法forName();
        Class c5 = Class.forName("com.sikiedu.chapter4.User1");
        System.out.println(c5==c2);
    }

}
