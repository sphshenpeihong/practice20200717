package com.sph.practice.test.markdown.test;

import com.google.common.collect.Lists;
import com.sph.practice.test.bean.User1;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/10/20 23:39
 * Description: Collectors
 *
 * @since 1.0.0
 */
public class CollectorsTest {

    /**
     * Collectors.toList()
     */
    @Test
    public void test1(){
        User1 u1 = new User1("zhangsan", "123");
        User1 u2 = new User1("lisi", "456");
        List<User1> user1List = Lists.newArrayList(u1, u2);
        List<String> collect = user1List.stream().map(User1::getUsername).collect(Collectors.toList());//累计名字属性到一个List中
        System.out.println(collect);
        /*
            [zhangsan, lisi]
         */
    }

    /**
     * Collectors.toSet()
     */
    @Test
    public void test2(){
        User1 u1 = new User1("zhangsan", "123");
        User1 u2 = new User1("lisi", "456");
        User1 u3 = new User1("zhangsan", "666");
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //累计名字属性到一个Set中
        Set<String> collect = user1List.stream().map(User1::getUsername).collect(Collectors.toSet());
        System.out.println(collect);
        /*
            [zhangsan, lisi]
         */
    }

    /**
     * Collectors.toCollection(Collection collection)
     */
    @Test
    public void test3(){
        User1 u1 = new User1("zhangsan", "123");
        User1 u2 = new User1("lisi", "456");
        User1 u3 = new User1("zhangsan", "666");
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //累积名字属性到一个TreeSet中 想要其它实现类的类型也可以，左边的TreeSet可以向上转型成Set
        Set<String> collect = user1List.stream().map(User1::getUsername).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
        /*
            [zhangsan, lisi]
         */
    }

    /**
     * Collectors.joining("|")：
     */
    @Test
    public void test4(){
        User1 u1 = new User1("zhangsan", "123");
        User1 u2 = new User1("lisi", "456");
        User1 u3 = new User1("zhangsan", "666");
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //也可以使用StringUtils.join方法连接   （将元素都转为String类型，并串联它们，中间的分隔符是逗号）
        String join = user1List.stream().map(User1::getUsername).collect(Collectors.joining("|"));
        System.out.println(join);
        /*
            zhangsan|lisi|zhangsan
         */
    }

    /**
     * Collectors.joining(",","[","]")
     */
    @Test
    public void test5(){
        User1 u1 = new User1("zhangsan", "123");
        User1 u2 = new User1("lisi", "456");
        List<User1> user1List = Lists.newArrayList(u1, u2);
        //Collectors.joining(分隔符，前缀，后缀)   有时候使用In拼接SQL语句可以用到
        String join = user1List.stream().map(User1::getUsername).collect(Collectors.joining(",","[","]"));
        System.out.println(join);
        /*
            [zhangsan,lisi]
         */
    }

    /**
     * Collectors.summingInt(User1::getId)
     */
    @Test
    public void test6(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        List<User1> user1List = Lists.newArrayList(u1, u2);
        //计算某个字段求和
        Integer sum = user1List.stream().collect(Collectors.summingInt(User1::getScore));
        System.out.println(sum);
        /*
            25
         */
    }

    /**
     * Collectors.groupingBy(User1::getParentId)
     */
    @Test
    public void test7(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //将List按泛型中的某个属性分组  （默认是全部List一组 类似mysql的分组）
        Map<Integer, List<User1>> groupMap = user1List.stream().collect(Collectors.groupingBy(User1::getParentId));
        for (Map.Entry<Integer, List<User1>> entry : groupMap.entrySet()) {
            //打印各自分组，打印时带上map的key
            System.out.println("当前分组号为：" + entry.getKey() + "| 对应的成员分别有：" + entry.getValue());
        }
        /*
            当前分组号为：-1| 对应的成员分别有：[User1{id=1, username='zhangsan', password='123', parentId=-1, score=12}, User1{id=2, username='lisi', password='456', parentId=-1, score=13}]
            当前分组号为：-2| 对应的成员分别有：[User1{id=3, username='wangwu', password='789', parentId=-2, score=22}]
         */
    }

    /**
     * Collectors.groupingBy(User1::getParentId, Collectors.toSet())
     */
    @Test
    public void test8(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //将Set按泛型中的某个属性分组  （默认是全部HashSet一组 类似mysql的分组）
        Map<Integer, Set<User1>> groupMap = user1List.stream().collect(Collectors.groupingBy(User1::getParentId, Collectors.toSet()));
        for (Map.Entry<Integer, Set<User1>> entry : groupMap.entrySet()) {
            //打印各自分组，打印时带上map的key
            System.out.println("当前分组号为：" + entry.getKey() + "| 对应的成员分别有：" + entry.getValue());
        }
        /*
            当前分组号为：-1| 对应的成员分别有：[User1{id=1, username='zhangsan', password='123', parentId=-1, score=12}, User1{id=2, username='lisi', password='456', parentId=-1, score=13}]
            当前分组号为：-2| 对应的成员分别有：[User1{id=3, username='wangwu', password='789', parentId=-2, score=22}]
         */
    }

    /**
     * Collectors.groupingBy(User1::getParentId, LinkedHashMap::new, Collectors.toSet())
     */
    @Test
    public void test9(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //3个参数 arg1:按条件分组 arg2:指定返回值Map的类型 arg3:指定Map的value的类型   (一般情况下就是HashMap和ArrayList类型  所以一般就是使用一个参数的即可)
        Map<Integer, Set<User1>> groupMap = user1List.stream().collect(Collectors.groupingBy(User1::getParentId, LinkedHashMap::new, Collectors.toSet()));
        for (Map.Entry<Integer, Set<User1>> entry : groupMap.entrySet()) {
            //打印各自分组，打印时带上map的key
            System.out.println("当前分组号为：" + entry.getKey() + "| 对应的成员分别有：" + entry.getValue());
        }
        /*
            当前分组号为：-1| 对应的成员分别有：[User1{id=1, username='zhangsan', password='123', parentId=-1, score=12}, User1{id=2, username='lisi', password='456', parentId=-1, score=13}]
            当前分组号为：-2| 对应的成员分别有：[User1{id=3, username='wangwu', password='789', parentId=-2, score=22}]
         */
    }

    /**
     * Collectors.groupingBy(User1::getParentId, Collectors.summingInt(User1::getId))
     */
    @Test
    public void test10(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //求出各部门的分数总和
        Map<Integer, Integer> groupMap = user1List.stream().collect(Collectors.groupingBy(User1::getParentId, Collectors.summingInt(User1::getScore)));
        for (Map.Entry<Integer, Integer> entry : groupMap.entrySet()) {
            System.out.println("当前部门序号为：" + entry.getKey() + "| 分数总和为：" + entry.getValue());
        }
        /*
            当前部门序号为：-1| 分数总和为：25
            当前部门序号为：-2| 分数总和为：22
         */
    }

    /**
     * Collectors.partitioningBy(s -> s.getScore() >= 60)
     */
    @Test
    public void test11(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //按照分数线及格与否进行分组
        Map<Boolean, List<User1>> groupMap = user1List.stream().collect(Collectors.partitioningBy(s -> s.getScore() > 20));
        for (Map.Entry<Boolean, List<User1>> entry : groupMap.entrySet()) {
            System.out.println("当前组为：" + entry.getKey() + "| 组员分别有：" + entry.getValue());
        }
        /*
            当前组为：false| 组员分别有：[User1{id=1, username='zhangsan', password='123', parentId=-1, score=12}, User1{id=2, username='lisi', password='456', parentId=-1, score=13}]
            当前组为：true| 组员分别有：[User1{id=3, username='wangwu', password='789', parentId=-2, score=22}]
         */
    }

    /**
     * Collectors.partitioningBy(s -> s.getScore() >= 60, Collectors.toSet())
     */
    @Test
    public void test12(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //arg1：True或False过滤条件 arg2：指定Map的value的类型
        Map<Boolean, Set<User1>> groupMap = user1List.stream().collect(Collectors.partitioningBy(s -> s.getScore() > 20, Collectors.toSet()));
        for (Map.Entry<Boolean, Set<User1>> entry : groupMap.entrySet()) {
            System.out.println("当前组为：" + entry.getKey() + "| 组员分别有：" + entry.getValue());
        }
        /*
            当前组为：false| 组员分别有：[User1{id=1, username='zhangsan', password='123', parentId=-1, score=12}, User1{id=2, username='lisi', password='456', parentId=-1, score=13}]
            当前组为：true| 组员分别有：[User1{id=3, username='wangwu', password='789', parentId=-2, score=22}]
         */
    }

    /**
     * Integer integer = list.stream().map(User1::getId).reduce(Integer::min).get();  //求list中的最小值
     */
    @Test
    public void test13(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //求list中的最小值
        Integer min = user1List.stream().map(User1::getId).reduce(Integer::min).get();
        System.out.println(min);
        /*
            1
         */
    }

    /**
     * Collectors.summarizingInt(Integer::valueOf)
     */
    @Test
    public void test14(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //汇总list的数量、和、最大值、最小值、平均值 （仅针对List泛型是数值类型的）
        IntSummaryStatistics collect = user1List.stream().map(User1::getScore).collect(Collectors.summarizingInt(Integer::valueOf));
        System.out.println(collect);
        /*
            IntSummaryStatistics{count=3, sum=47, min=12, average=15.666667, max=22}
         */
    }

    /**
     * Collectors.toMap(User1::getParentId, e -> e, (oldValue, newValue) -> newValue)
     */
    @Test
    public void test15(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, 13);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        //arg1:key生成器 arg2:value生成器 arg3:当key相同时，指定取oldValue还是newValue
        Map<Integer, User1> map = user1List.stream().collect(Collectors.toMap(User1::getId, e -> e, (oldValue, newValue) -> newValue));
        for (Map.Entry<Integer, User1> entry : map.entrySet()) {
            System.out.println("当前key为：" + entry.getKey() + "| 对应的value为：" + entry.getValue());
        }
        /*
            当前key为：1| 对应的value为：User1{id=1, username='zhangsan', password='123', parentId=-1, score=12}
            当前key为：2| 对应的value为：User1{id=2, username='lisi', password='456', parentId=-1, score=13}
            当前key为：3| 对应的value为：User1{id=3, username='wangwu', password='789', parentId=-2, score=22}
         */
    }

    /**
     * toMap获取的value为空时，会报空指针异常
     */
    @Test
    public void test16(){
        User1 u1 = new User1(1, "zhangsan", "123", -1, 12);
        User1 u2 = new User1(2, "lisi", "456", -1, null);
        User1 u3 = new User1(3, "wangwu", "789", -2, 22);
        List<User1> user1List = Lists.newArrayList(u1, u2, u3);
        Map<Integer, Integer> map = user1List
                .stream()
                .collect(Collectors.toMap(User1::getId,
                        //value空指针处理
                        e -> Optional.ofNullable(e.getScore()).orElse(0),
                        (oldValue, newValue) -> newValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    /**
     *
     */
    @Test
    public void test17(){

    }

    /**
     *
     */
    @Test
    public void test18(){

    }

    /**
     *
     */
    @Test
    public void test19(){

    }



}
