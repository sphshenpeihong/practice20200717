package com.sph.practice.test.markdown.annotationAndReflect;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/11/15 23:15
 * Description:利用反射先去获取变量、方法、构造方法进行测试
 *
 * @since 1.0.0
 */
public class ReflectTest {

    /**
     * 反射练习
     */
    @Test
    public void test() throws Exception {
        //获取某个类的Class对象
        Class c1 = Class.forName("com.sph.practice.test.markdown.annotationAndReflect.UserPO");
        //使用Class对象，实例化一个对象 (只能使用空参构造方法)
        UserPO po = (UserPO)c1.newInstance();
        System.out.println(po);
        /*
            UserPO{id='null', username='null', password='null'}
         */
        //======== Constructor start ======
        //1、获取构造方法对象数组(该Class所有构造方法对象)
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        /*
            public com.sph.practice.test.markdown.annotationAndReflect.UserPO(java.lang.String,java.lang.String,java.lang.String)
            public com.sph.practice.test.markdown.annotationAndReflect.UserPO()
         */
        //获取指定的构造方法，需要指定参数，不然不知道要获取哪个构造方法对象
        Constructor constructor = c1.getConstructor(String.class, String.class, String.class);
        System.out.println(constructor);
        /*
            public com.sph.practice.test.markdown.annotationAndReflect.UserPO(java.lang.String,java.lang.String,java.lang.String)
         */
        //使用构造方法对象去实例化对象，若是有参的构造方法，那么需要传递初始值才行
        UserPO userPO = (UserPO) constructor.newInstance("1", null, null);
        System.out.println(userPO);
        /*
            UserPO{id='1', username='null', password='null'}
         */
        //试试构造方法私有化，设置可接触的，是否可以实例化对象
        //getConstructor和getDeclaredConstructor的区别
        //getConstructor：只能获取public的构造方法对象
        //getDeclaredConstructor：可以获取到private的构造方法对象
        Constructor constructor1 = c1.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        UserPO u1 = (UserPO) constructor1.newInstance("2");
        System.out.println(u1);
        /*
            UserPO{id='2', username='null', password='null'}
         */

        //======== Constructor end ======

        //======== Field start ======
        //获取成员变量数组对象
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        UserPO u2 = new UserPO();
        Field id = c1.getDeclaredField("id");
        id.setAccessible(true);
        Annotation[] idAnnotations = id.getDeclaredAnnotations();
        for (Annotation idAnnotation : idAnnotations) {
            System.out.println("看看变量的注解");
            Class<? extends Annotation> fieldAnnotation = idAnnotation.annotationType();
            System.out.println(fieldAnnotation);
            System.out.println(idAnnotation);
        }
        id.set(u2, "666");
        System.out.println("该值为：" + id.getName() + u2.getId());

        //获取Mehtod对象 , 会获取到该类以及父类的所有public
        //Method[] methods = c1.getMethods();
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取某个方法对象后，然后调用这个方法
        Method toString = c1.getDeclaredMethod("toString");
        UserPO u5 = new UserPO("777", "123", "456");
        System.out.println("====");
        //调用方法，需要指定调用的是哪个对象的，并且有参数的话，需要记得传递参数呢
        System.out.println(toString.invoke(u5));

        //===== Method end====

        //获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


    }

    /**
     * 通过反射获取构造方法、成员变量、方法、变量
     */
    @Test
    public void test1() throws Exception {
        Class c1 = UserPO.class;
        //Class对象实例化对象的话，只支持空参构造方法
        UserPO u1 = (UserPO) c1.newInstance();

        //获取Class对象中指定的构造方法对象，加了Declared说明private的也可以获取到
        Constructor constructor1 = c1.getDeclaredConstructor(String.class);
        //虽然声明成private的可以获取到，但是需要设置可接触才能使用
        constructor1.setAccessible(true);
        //实例化对象，需设置初始值
        UserPO u2 = (UserPO) constructor1.newInstance("123");
        System.out.println(u2);
        /*
            UserPO{id='123', username='null', password='null'}
         */

        //获取Class对象中的变量
        Field id = c1.getDeclaredField("id");
        //凡是获取到的对象是private的，要使用之前都要设置成可接触的
        id.setAccessible(true);
        UserPO u3 = new UserPO();
        //可以给指定对象赋值
        id.set(u3, "666");
        System.out.println(u3);
        /*
            UserPO{id='666', username='null', password='null'}
         */

        //获取Class中的toString方法
        Method method = c1.getDeclaredMethod("toString", null);
        UserPO u4 = new UserPO("1", "123", "456");
        String invoke = (String) method.invoke(u4, null);
        System.out.println(invoke);
        /*
            UserPO{id='1', username='123', password='456'}
         */

        //获取某个变量的注解
        Field fieldId = c1.getDeclaredField("id");
        fieldId.setAccessible(true);
        JSONField annotation = fieldId.getAnnotation(JSONField.class);
        System.out.println(annotation);
        /*
            @com.alibaba.fastjson.annotation.JSONField(format=, label=, jsonDirect=false, unwr。。。
         */

        //获取注解的值
        Field field = c1.getDeclaredField("username");
        field.setAccessible(true);
        //判断是否存在该注解
        if (field.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = field.getAnnotation(MyAnnotation.class);
            //获取注解指定变量的值
            String s = myAnnotation.seldDefine();
            System.out.println(s);
            /*
                123123
             */
        }
    }

    /**
     * 判断变量是否存在注解，若存在的话，则获取注解，然后再获取注解某个变量的值
     */
    @Test
    public void test2() throws Exception {
        Class c1 = UserPO.class;
        Field field = c1.getDeclaredField("username");
        field.setAccessible(true);
        if (field.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
            String s = annotation.seldDefine();
            System.out.println(s);
        }
    }

    //反射获取泛型
    /**
     *
     */
    @Test
    public void test3() throws Exception {
        //通过反射获得方法的形参类型
        Method method = ReflectTest.class.getDeclaredMethod("invodeMethod", Map.class, String.class, List.class);
        //获得方法形参类型，返回值是Class对象
        Class[] parameterTypes = method.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType);
        }
        System.out.println("========");
        //获得方法形参类型()
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
        }
    }

    public void invodeMethod(Map<String, UserPO> map, String username, List<String> list){

    }

    /**
     * 试试看Method对象的 getParameterTypes和getGenericParameterTypes的区别
     * 两个都是获取方法参数的类型，但是第二个是连泛型都能给获取到
     */
    @Test
    public void test4() throws Exception {
        Method method = ReflectTest.class.getDeclaredMethod("invodeMethod", Map.class, String.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) genericParameterType;
                //获得泛型里面的类型
                Type[] arguments = type.getActualTypeArguments();
                for (Type argument : arguments) {
                    System.out.println(argument);
                }
            }
        }
    }

    /**
     * 给定一个实体类，获取name和value
     */
    private void test5(Object o) throws ClassNotFoundException, IllegalAccessException {
        //获取某个类的Class对象
        Class<?> clazz = o.getClass();
        // 如果value不为null，则set进Map中
        HashMap<String, String> paramMap = Maps.newHashMap();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(o);
            if (value == null) {
                continue;
            }
            paramMap.put(field.getName(), (String) value);
        }

        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     *
     */
    @Test
    public void test6() throws IllegalAccessException, ClassNotFoundException {
        UserPO userPO = new UserPO("1", null, "456");
        test5(userPO);
    }




}
