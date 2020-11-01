package com.sph.practice.test.markdown.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by Shen Peihong on 2020/10/20 0:13
 * Description:测试String类相关方法
 *
 * @since 1.0.0
 */
public class StringTest {

    /**
     *  split
     */
    @Test
    public void test(){

        String citys = "上海|北京|广州|深圳";
        String[] strArray = citys.split("\\|");
        for (String str : strArray) {
            System.out.println(str);
            /*
                上海
                北京
                广州
                深圳
             */
        }
    }

    /**
     * concat
     */
    @Test
    public void test1(){
        String str  = "hello,";
        String concat = str.concat("world!");
        System.out.println(concat);
        /*
            hello,world!
         */
    }

    /**
     * String trim()
     */
    @Test
    public void test2(){
        String str = " hello,world! ";
        String trim = str.trim();
        System.out.println(trim);
        /*
            hello,world!
         */
    }

    /*
        getBytes() //将String编码成字节数组
        indexOf("abc") //返回指定字符串第一次出现的字符串的索引
        lastIndexOf(".")//返回指定字符串最后一次出现的索引      substring(originalFilename.lastIndexOf("."))
        isEmpty()  //为空时是false,  length为0的话，也算true的
        length()  //字符串的长度
        replace("-","")和replaceAll("-","")  //两个都是全部替换，但是后者支持正则表达式
        split("\\|") //遇到|分割字符串
        trim() //返回一个字符串，去掉前后的空格
        toCharArray(); //将字符串转换成字符数组
        format(String formatStr,Object args1);  //输出字符串，第一个参数可以%s或其它格式，后面的参数传入该值
        startsWith(String prefix); //判断字符串开头是否和参数的字符串相同   一般判断
        toLowerCase();  //将所有字符串转换成小写的
        toUpperCase();  //将所有字符串转换成大写的
        valueOf(100);  //将各种基本类型转成String类型，同理 使用Integer等基本类型的包装类也可以将String类型转成基本类型的包装类类型
     */

    /**
     * byte[] getBytes()  将String编码成字节数组
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str = "hello,world!";
        byte[] bytes = str.getBytes("utf-8");
        System.out.println(bytes);
        /*
            [B@6b57696f
         */
    }

    /**
     * indexOf("abc") //返回指定字符串第一次出现的字符串的索引
     */
    @Test
    public void test4(){
        String str = "hello,world";
        int index = str.indexOf("wor");//下标从0开始计算
        System.out.println(index);
        /*
            6
         */
    }

    /**
     * lastIndexOf(".")  返回指定字符串最后一次出现的索引
     */
    @Test
    public void test5(){
        String str = "hello,hello";
        int lastIndex = str.lastIndexOf("hello");//返回指定字符串最后一次出现的索引
        System.out.println(lastIndex);
        /*
            6
         */
    }

    /**
     * substring
     */
    @Test
    public void test6(){
        String str = "images.png";
        int lastIndex = str.lastIndexOf(".png");
        //当下标不为-1代表已匹配上字符串
        if (-1 != lastIndex){
            //已获得后缀起始索引，则通过subString(beginIndex)或subString(beginIndex, endIndex)方法可以截取字符串
            String suffix = str.substring(lastIndex);
            System.out.println(suffix);
            /*
                .png
             */
        }else{
            System.out.println("匹配不上");
        }

    }

    /**
     * format(String formatStr,Object args1);  //输出字符串，第一个参数可以%s或其它格式，后面的参数传入该值
     */
    @Test
    public void test7(){
        String username = "zhangsan";
        String password = "123456";
        String format = String.format("账号：%s , 密码：%s", username, password);
        System.out.println(format);
        /*
            账号：zhangsan , 密码：123456
         */
    }

    /**
     * startsWith(String prefix);//判断字符串开头是否和参数的字符串相同   一般判断
     */
    @Test
    public void test8(){
        String name = "张大地";
        boolean flag = name.startsWith("张");
        if (flag){
            System.out.println("开头已匹配上");
        }else{
            System.out.println("开头匹配不上");
        }
    }

    /**
     *
     */
    @Test
    public void test9(){
        //一般判断文件类型可以使用String类的 endsWith(suffix str)方法和lastIndexOf(suffix str)方法
        String name = "image.png";
        boolean flag = name.endsWith("png");
        if (flag){
            System.out.println("后缀已匹配上");
        }else{
            System.out.println("匹配不上");
        }
    }

    /**
     * toLowerCase();  //将所有字符串转换成小写的
     */
    @Test
    public void test10(){
        String str = "Hello";
        String lowerCase = str.toLowerCase();
        System.out.println(lowerCase);
        /*
            hello
         */
    }

    /**
     *
     */
    @Test
    public void test11(){
        String str = "Hello";
        String UpperCase = str.toUpperCase();
        System.out.println(UpperCase);
        /*
            HELLO
         */
    }

    /**
     *
     */
    @Test
    public void test12(){
        //String的静态方法valueOf支持将各种数值类型转换成String类型
        String value = String.valueOf(10L);
        System.out.println(value);
        /*
            10
         */
    }

}
