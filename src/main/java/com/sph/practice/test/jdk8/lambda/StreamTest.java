package com.sph.practice.test.jdk8.lambda;

import com.sph.practice.test.bean.User1;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shen Peihong on 2020/5/10 18:46
 * Description:
 *
 * @since 1.0.0
 */
public class StreamTest {

    //stream().filter()方法
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("张4");
        list.add("张5");
        list.add("张6");
        list.add("李9");
        //过滤出list中姓张的元素，不姓张则去除 使用Stream<T>接口提供的filter方法实现即可 filter方法形参是(Predicate<T>接口)
        //filter(Predicate<T> predicate)方法，循环遍历集合流中的数据，形参是Predicate<T>接口，实现接口里面的test方法
        //把我们想要进行判断的代码写在实现方法test中，到时候符合条件的话会返回true
        //而filter方法的实现类，恰好就是遍历集合流时，判断形参为true的话，才会留下当前元素。false的话，就会remove掉当前元素
        System.out.println("过滤前："+list);
        //注：由于方法的参数是函数式接口，我们只需要知道里面抽象方法的用途，然后去根据抽象方法的返回值，参数进行编写代码
        List<String> collect = list.stream().filter((String s) -> {
            return s.startsWith("张");
        }).collect(Collectors.toList());
        //调用Stream<T>接口里面的方法去对集合流进行操作后，最后需要调用collect(Collectors.toList())去将stream流转化成List
        System.out.println("过滤后："+collect);
    }

    //stream().foreach()方法
    @Test
    public void foreachTest(){
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("张4");
        list.add("张5");
        list.add("张6");
        list.add("李9");
        list.stream();
        list.stream().forEach(s->System.out.println(s)); //foreach遍历执行操作当前元素

    }

    //stream().map()方法
    @Test
    public void mapTest(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        //map形参是Apply类型，接口的作用就是映射(将A类型转换成B类型)
        Stream<Integer> stream = list.stream().map((String s) -> {
            return Integer.parseInt(s);
        });
        stream.forEach(i->System.out.println(i)); //forEach遍历
    }

    //stream().count()方法
    @Test
    public void countTest(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        //终结方法，统计流中个数
        long count = list.stream().count();
        System.out.println(count);
    }

    //stream().limit(long maxSize)方法
    @Test
    public void limitTest(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Stream<String> stream = list.stream().limit(3);
        stream.forEach(s->System.out.println(s));
    }

    //stream().skip(long maxSize)方法
    @Test
    public void skipTest(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Stream<String> stream = list.stream().skip(3);
        stream.forEach(s->System.out.println(s));
    }

    //stream().concat方法
    @Test
    public void concatTest(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        List<String> list1 = new ArrayList<String>();
        list1.add("100");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = list1.stream();
        Stream<String> concatStream = Stream.concat(stream1, stream2);
        concatStream.forEach(s->System.out.println(s));
    }

    //计算百分比
    @Test
    public void percentage(){

        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(2);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);

        BigDecimal b1 = new BigDecimal("6");
        BigDecimal b2 = new BigDecimal("6");
        System.out.println(b1.intValue());

        BigDecimal b3 = b1.divide(b2,4,BigDecimal.ROUND_HALF_UP);
        System.out.println(b3);
        double accuracy_num = b3.doubleValue() * 100;
        System.out.println(df.format(accuracy_num)+"%");

    }

    //
    @Test
    public void jian(){
        BigDecimal b1 = new BigDecimal("0");
        BigDecimal b2 = new BigDecimal("0");
        System.out.println(b1.subtract(b2));
    }

    @Test
    public void timestampTest(){
        //Date转String
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String formatDate = df.format(date);
        Timestamp t1 = Timestamp.valueOf(formatDate);
        String s2 = "2020-05-26 10:51:05.0";
        Timestamp t2 = Timestamp.valueOf(s2);
        System.out.println("看看这个类型是什么："+t1);
        System.out.println((t1.getTime()-t2.getTime())/60/1000); //毫秒级别  /1000/60
        date.toString();
        //String转Timestamp
       /* new TimeS*/
    }

    @Test
    public void timestampTest1(){
        //Date转String
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String formatDate = df.format(date);
        Timestamp t1 = Timestamp.valueOf(formatDate);
        String s2 = "2020-05-26 10:51:05.0";
        Timestamp t2 = Timestamp.valueOf(s2);
        System.out.println("看看这个类型是什么："+t1);
        System.out.println((Timestamp.valueOf("0").getTime()-t2.getTime())); //毫秒级别  /1000/60
        date.toString();
        //String转Timestamp
        /* new TimeS*/
    }

    /**
     * 空指针异常
     */
    @Test
    public void nullTest(){
        User1 u = new User1();
        User1 u1 = null;
        String s = null;
        String d = "123";

        if (s.equals("0")){ //用已知字符串去调用方法，可以确保绝对不会空指针异常
            //为空的对象，只要这个对象去使用了它本身任何方法，那么都会引起空指针异常
            System.out.println("1231");
        }
        u = u1;
        System.out.println("");
    }

    /**
     * of(T...values)方法
     */
    @Test
    public void ofTest(){
        Stream<String> tempStream = Stream.of("zhangsan", "lisi", "wangwu");
        List<String> collect = tempStream.collect(Collectors.toList());
        System.out.println(collect);
    }

}
