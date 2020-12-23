package com.sph.practice.test.jdk8.lambda;

import com.sph.practice.test.bean.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/5/28 12:57
 * Description:
 *
 * @since 1.0.0
 */
public class JDK8Test {

    /**
     * Collectors.toList()  map映射然后转换成List
     */
    @Test
    public void collectorsSimple(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        List<String> collect = list.stream().map(User::getUsername).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * Collectors.toSet()   map映射然后转换成Set
     */
    @Test
    public void collectorsTest1(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Set<String> collect = list.stream().map(User::getUsername).collect(Collectors.toSet());
        System.out.println(collect);
    }

    /**
     * Collectors.toCollection(TreeSet::new)   map映射然后转换成TreeSet
     */
    @Test
    public void collectorsTest6(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Set<String> treeSet = list.stream().map(User::getUsername).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);
    }

    /**
     * Collectors.tojoining()   map映射然后把所有元素转成String并用分隔符连接起来
     */
    @Test
    public void collectorsTest2(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        String collect = list.stream().map(User::getUsername).collect(Collectors.joining("|")); //也可以使用StringUtils.join方法连接
        System.out.println(collect);
    }

    /**
     * StringUtils.join(list,"|")
     */
    @Test
    public void collectorsTest3(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        List<String> collect = list.stream().map(User::getUsername).collect(Collectors.toList()); //也可以使用StringUtils.join方法连接
        System.out.println(collect);

        String join = StringUtils.join(collect, "|");
        System.out.println(join);
    }

    /**
     * Collectors.summingInt()   将List<User>中某个Int类型的值 累加
     */
    @Test
    public void collectorsTest4(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Integer collect = list.stream().collect(Collectors.summingInt(User::getId));
        System.out.println(collect);
    }

    /**
     * Collectors.groupingBy() 分组
     */
    @Test
    public void collectorsTest5(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Map<Integer, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getParentId));
        Set<Map.Entry<Integer, List<User>>> entrySet = collect.entrySet();
        for (Map.Entry<Integer, List<User>> entry : entrySet) {
            List<User> entryValue = entry.getValue();
            List<String> collect1 = entryValue.stream().map(User::getUsername).collect(Collectors.toList());
        }
    }

    /**
     * Collectors.groupingBy() 分组  多参数
     */
    @Test
    public void collectorsTest50(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        //Runnable 线程
        //Supplier 生产接口
        //Consumer函数接口 消费接口
        //Predicate函数式接口，返回值是true 里面是判断式
        list.stream().collect(Collectors.groupingBy(User::getParentId)); //Function函数式接口，将T类型转换成R类型
    }

    /**
     * Collectors.groupingBy()  分组计算总和
     */
    @Test
    public void collectorsTest7(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Map<Integer, Integer> collect = list.stream().collect(Collectors.groupingBy(User::getParentId, Collectors.summingInt(User::getId)));

    }

    public static void main(String[] args) {
        List<String> list = null;
        list.add("111");
        System.out.println("打印了");
    }

    /**
     * Collectors.groupingBy()  试试分组后 对分组后的元素求各分组的最大值
     */
    @Test
    public void collectorsTest70(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        /*Map<Integer, Integer> collect = list.stream().collect(Collectors.groupingBy(User::getParentId, Collectors.min));*/

    }

    /*
        groupingBy()分组的话，可能是对类类型某个字段进行分组，Map的返回值是整个List<类类型>,支持两重分组
        比方一个VO类里面有考试id，也有试卷id的话，我们可以对考试id先进行分组，然后对已分组后的数据再进行按试卷id进行分组
        最后返回的值的类型是Map<String, Map<String, List<类类型>>>
     */


    /**
     * Collectors.partitioningBy  按照分数及格与否对学生进行分组
     */
    @Test
    public void collectorsTest8(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Map<Boolean, List<User>> collect = list.stream().collect(Collectors.partitioningBy(s -> s.getScore() >= 60)); //按照分数及格与否对学生进行分组
        Set<Map.Entry<Boolean, List<User>>> entrySet = collect.entrySet();
        for (Map.Entry<Boolean, List<User>> entry : entrySet) {
            for (int i=0;i<entry.getValue().size();i++){
                System.out.println(entry.getKey()+"："+entry.getValue().get(i).getUsername());
            }
        }

    }

    /**
     * Collectors.partitioningBy  按照分数及格与否对学生进行分组
     * //arg1：True或False过滤条件  arg2：指定Map的value的类型
     */
    @Test
    public void collectorsTest18(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Map<Boolean, Set<User>> collect = list.stream().collect(Collectors.partitioningBy(s -> s.getScore() >= 60, Collectors.toSet()));

    }

    /**
     * toMap()
     */
    @Test
    public void collectorsTest19(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        //key生成器筛选，值生成器筛选，  把list中需要的元素 以key/value的形式存储到Map集合中
        //toMap的重载方法参数   两个参数时，  arg1:key生成器   arg2:value生成器
        // （但是这里Key生成器有一个问题，那么就是不能重复，识别出重复时，会抛duplicate key异常 重复key） 与我们平常使用Map会覆盖恰好不同
        // 如果想要实现相同key ，用新值覆盖老值的方法的话，那么需要再第三个参数指定
        Map<Integer, User> collect = list.stream().collect(Collectors.toMap(User::getParentId, e -> e, (oldValue, newValue) -> newValue));
        //arg1:key生成器 arg2:value生成器  arg3:当key相同时，指定取oldValue还是newValue
    }

    /**
     * 继续对Collectors.toMap()方法进行操作
     */
    @Test
    public void collectorsTest190(){
        User user = new User("1","111");
        User user1 = new User("2","222");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        //下面对一个List<VO>类改成Map映射类型
        //toMap里面的函数式接口是Function 也就是转换性接口
        Map<String, String> collect = list.stream().collect(Collectors.toMap(User::getUsername, User::getPassword, (oldValue, newValue) -> newValue));//toMap有三个参数，参数1：key生成器，参数2：value生成器，参数3，规定当key值冲突时，新值替换掉旧值 这种一般不会，因为key会是唯一的
        Set<Map.Entry<String, String>> entrySet = collect.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * summarizingInt()  //汇总list的数量、和、最大值、最小值、平均值 （仅针对List泛型是数值类型的）
     */
    @Test
    public void collectorsTest20(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Integer::valueOf));
        System.out.println(collect.getCount());
        System.out.println(collect.getSum());
    }


    /**
     * Collectors.joining(分隔符，前缀，后缀)   有时候使用In拼接SQL语句可以用到
     */
    @Test
    public void collectorsTest9(){
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        String collect = list.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

    /**
     * Collectors.mapping(长度，转换成list)   有时候使用In拼接SQL语句可以用到
     */
    @Test
    public void collectorsTest10(){
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        //利用mapping将String类型转Integer类型
        List<Integer> collect = list.stream().collect(Collectors.mapping(Integer::valueOf, Collectors.toList()));

    }

    /**
     * map的作用和mapping的作用是一样的，里面形参都是使用Function函数式接口，方法的底层都是在做将一个类型去转换成其它类型
     */
    @Test
    public void collectorsTest11(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        //mapping可以将list本身的类型去转换成其它类型，试试将PO类去转换成String?
        List<String> collect = list.stream().collect(Collectors.mapping(User::getUsername, Collectors.toList()));
        System.out.println(collect);
    }

    @Test
    public void stringToInteger(){
        int i = 1;
        String s = "123";
        Integer integer = Integer.valueOf(s);
        System.out.println(integer);
    }

    /**
     * collectingAndThen
     */
    @Test
    public void collectorsTest12(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        User u4 = new User(4,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        //collectingAndThen  对归纳动作结束之后，再对归纳的结果进行处理  参数1是转换类型，可以toList 参数2
        Integer collect = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), e -> e.size()+1));  //形参e是list列表
        System.out.println(collect);

    }

    /**
     * counting
     */
    @Test
    public void collectorsTest13(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        //统计list的长度
        long count = list.stream().count();
        Long collect = list.stream().collect(Collectors.counting());
        System.out.println(collect);

    }

    /**
     * minBy/maxBy
     */
    @Test
    public void collectorsTest14(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        /*list.stream().map(User::getId).reduce(Integer::)*/

    }

    /**
     * reduce
     */
    @Test
    public void collectorsTest15(){
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Integer integer = list.stream().map(User::getId).reduce(Integer::min).get();  //求list中的最小值
        System.out.println(integer);

    }

    /**
     * Collectors的reducing
     */
    @Test
    public void collectorsTest16(){
        User u1 = new User(2,"zhangsan","zhangsan",-1,61);
        User u2 = new User(1,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Optional<Integer> collect = list.stream().map(User::getId).collect(Collectors.reducing(Integer::min));
        System.out.println(collect);

    }

    /**
     * Collectors.groupingBy()  //1个参数：按给定元素分组   2个参数：按给定元素分组，并指定返回值的类型（Map的value的类型,不赋值，默认是List）
     * //3个参数   arg1:按条件分组  arg2:指定返回值Map的类型  arg3:指定Map的value的类型
     */
    @Test
    public void collectorsTest17(){
        User u1 = new User(2,"zhangsan","zhangsan",-1,61);
        User u2 = new User(1,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        LinkedHashMap<Integer, Set<User>> collect = list.stream().collect(Collectors.groupingBy(User::getParentId, LinkedHashMap::new, Collectors.toSet()));

    }


    /**
     * 使用Integer包装类去比较两个数 或对两个数进行操作
     */
    @Test
    public void compareBS(){
        System.out.println(Integer.sum(1,2));
    }

    /**
     * 使用Integer包装类去比较两个数 或对两个数进行操作
     */
    @Test
    public void stringTranform(){
        //求和
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Double collect = list.stream().collect(Collectors.averagingLong(Long::valueOf)); //使用求平均值，无论使用映射哪种类型，得出结果都是double
        System.out.println(collect);
    }

    @Test
    public void collectosTest(){
        User u1 = new User(1,"zhangsan","zhangsan",-1);
        User u2 = new User(2,"lisi","lisi",-1);
        User u3 = new User(3,"wangwu","wangwu",-2);
        List<User> list = new ArrayList<>();
    }

    /**
     * Optional类的了解
     */
    @Test
    public void collectorsTest21() throws Exception {
        User u1 = new User(1,"zhangsan","zhangsan",-1,61);
        User u2 = new User(2,"lisi","lisi",-1,59);
        User u3 = new User(3,"wangwu","wangwu",-2,50);
        List<User> list = new ArrayList<>();
        List<User> list1 = new ArrayList<>();
        int i = 100;
        String s = null;
        list.add(u1);
        list.add(u2);
        list.add(u3);
        System.out.println(list);
        Optional<List<User>> listOptional = Optional.ofNullable(list);
        if(listOptional.isPresent()){
            /*listOptional.*/
        }else{
            throw new Exception();
        }

    }

    /**
     * Stream流的 sorted()方法
     */
    @Test
    public void collectorsTest22() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(0);
        list.add(-1);
        list.stream().sorted().forEach(System.out::println); //形参也可以省略 要保证方法可以接收这个形参

    }

    /**
     * Collections.singletonList();方法的使用
     */
    @Test
    public void test0(){
        List<String> list = Collections.singletonList("zhangsan"); //只有一个String类型的值，但是我们又不想是String  只想用List去声明，就不必使用ArrayList，而是使用SingletonList去实例化
        System.out.println(list);
        Map<Object, Object> map = Collections.emptyMap();
    }

    /**
     *
     */
    @Test
    public void test1(){
        //求和List<Integer>
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.stream().reduce(Integer::sum);
    }

    @Test
    public void test2(){

        Double j =  (Double)Math.ceil(55/60);
        System.out.println(j);
        Integer i = j.intValue();
        System.out.println(i);
        System.out.println(i/60%60==0);
        System.out.println(i/60%60);
        //Integer temp = i/60%60==0 ? i/60 : (i/60+1) ;
        //System.out.println(temp);
    }

}
