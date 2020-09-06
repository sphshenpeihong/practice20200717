package com.sph.practice.test.google.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sph.practice.test.bean.UserParam;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/8/27 16:37
 * Description:练习一下谷歌提供的工具类
 *
 * @since 1.0.0
 */
public class GUAVAUtils {

    /**
     * equals
     * 比较两个对象是否相同，引用类型比较地址，基本类型比较值
     */
    @Test
    public void equalsTest(){
        boolean result = Objects.equal("1", "1");
        System.out.println(result);

        UserParam userParam = new UserParam("1");
        UserParam userParam3 = userParam;
        UserParam userParam2 = userParam.clone();
        UserParam userParam1 = new UserParam("1");
        boolean result1 = Objects.equal(userParam, userParam3);
        System.out.println(result1);
    }

    @Test
    public void equalsTest1(){
        UserParam userParam = new UserParam("1");
        UserParam userParam4 = null ;
        UserParam userParam3 = userParam;
        UserParam userParam2 = userParam.clone();
        UserParam userParam1 = new UserParam("1");
        boolean result1 = Objects.equal(userParam4, null);
        System.out.println(result1);
    }

    /**
     * JDK1.8的equals
     */
    @Test
    public void equalsTest2(){
        UserParam userParam = new UserParam("1");
        UserParam userParam1 = null;

        boolean result1 = java.util.Objects.equals(userParam1,null);
        System.out.println(result1);
    }

    /**
     * hashCode
     */
    @Test
    public void hashCodeTest(){
        int hashCode = Objects.hashCode("a");
        System.out.println(hashCode);
    }

    /**
     * Lists.newArrayList()
     * //可初始化数据 该方法的参数可以初始化数组、list、Set、Iterator、数组列各种类型
     */
    @Test
    public void test(){
        //利用List.newArrayList()去初始化list实例 不用自己去new 代码简洁性
        List<String> list = Lists.newArrayList(); //作用和new ArrayList<>();一样
        Iterable<String> list1 = Lists.newArrayList("111", "222", "333"); //可初始化数据
        Iterator<String> iterator = list1.iterator();
        List<String> list2 = Lists.newArrayList(iterator);
        System.out.println(list2);
    }

    /**
     * newArrayListWithCapacity
     */
    @Test
    public void test1(){
        List<String> list = Lists.newArrayListWithCapacity(1); //使用这种去实例化list，设置容量大小，会自动扩容
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        System.out.println(list);
    }

    /**
     * newArrayListWithExpectedSize
     */
    @Test
    public void test2(){
        List<String> list = Lists.newArrayListWithExpectedSize(2);
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        List<String> list1 = new ArrayList<>(2);
        list1.add("111");
        list1.add("222");
        list1.add("333");
        list1.add("444");
        System.out.println(list1);
    }

    /**
     * Lists.reverse(list); //将list反序
     */
    @Test
    public void test3(){
        List<Integer> list = Lists.newArrayList(1, 3, 4);
        List<Integer> reverse = Lists.reverse(list); //将list反序
        System.out.println(reverse);
    }

    /**
     * Lists.transform
     */
    @Test
    public void test4(){
        UserParam userParam1 = new UserParam("1");
        userParam1.setUsernmae("123123");
        UserParam userParam2 = new UserParam("2");
        UserParam userParam3 = new UserParam("3");
        List<UserParam> list = Lists.newArrayList(userParam1,userParam2,userParam3);
        List<String> transform = Lists.transform(list, UserParam::getUsernmae);//用法和stream流的map()转换一样
        System.out.println(transform);
    }

    /**
     * Lists.partition
     */
    @Test
    public void test5(){
        List<String> list = Lists.newArrayListWithExpectedSize(2);
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        List<List<String>> partition = Lists.partition(list, 2); //将list去切割，每份是2
        System.out.println(partition.size());
    }

    /**
     * Sets.newHashSet
     */
    @Test
    public void test6(){
        Set<String> set = Sets.newHashSet(); //初始化，和使用new HashSet<>()方式一样
        set.add("111");
        set.add("222");
        set.add("333");
        set.add("444");
        System.out.println(set);
    }

    /**
     * Sets.filter
     */
    @Test
    public void test7(){
        Set<String> set = Sets.newHashSet(); //初始化，和使用new HashSet<>()方式一样
        set.add("111");
        set.add("222");
        set.add("333");
        set.add("444");
        Set<String> filter = Sets.filter(set, e -> e.equals("111"));//Predicate过滤，和stream流的filter作用一样
        System.out.println(filter);
    }

    /**
     * Sets.difference 补集
     */
    @Test
    public void test8(){
        Set<String> small = Sets.newHashSet(); //初始化，和使用new HashSet<>()方式一样
        small.add("111");
        small.add("223");
        small.add("999");
        Set<String> big = Sets.newHashSet(); //初始化，和使用new HashSet<>()方式一样
        big.add("111");
        big.add("223");
        big.add("22343");
        big.add("24323");
        Sets.SetView<String> difference = Sets.difference(big, small); //请arg1的补集 也即是arg1中-arg2中相同的 剩余的就是arg1的补集
        Iterator iterator = difference.iterator();
        List<String> list = Lists.newArrayList(iterator);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * Sets.intersection  交集
     */
    @Test
    public void test80(){
        Set<String> set = Sets.newHashSet(); //初始化，和使用new HashSet<>()方式一样
        set.add("111");
        set.add("223");
        Set<String> set1 = Sets.newHashSet(); //初始化，和使用new HashSet<>()方式一样
        set1.add("111");
        set1.add("223");
        set1.add("22343");
        set1.add("24323");
        Sets.SetView<String> intersection = Sets.intersection(set, set1); //集合1去跟集合2比较，筛选出集合1中包含在集合2里面的元素
        Iterator iterator1 = intersection.iterator();
        HashSet hashSet1 = Sets.newHashSet(iterator1);
        System.out.println("长度：" + hashSet1.size());
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }



    /**
     * 组合 Sets.combinations
     */
    @Test
    public void test9(){
        Set<String> set = Sets.newHashSet("111", "222", "333");
        Set<Set<String>> combinations = Sets.combinations(set, 2);//将Set中的元素组合 C 参数1.size()取参数2的数字
        for (Set<String> combination : combinations) {
            List<String> list = Lists.newArrayList(combination);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    /**
     * Sets.union 求并集
     */
    @Test
    public void test10(){
        Set<String> set = Sets.newHashSet("111", "222", "333");
        Set<String> set1 = Sets.newHashSet("111", "555", "666");
        Sets.SetView<String> union = Sets.union(set, set1); //求并集
        HashSet<String> set2 = Sets.newHashSet(union.iterator());
        List<String> list = Lists.newArrayList(set2);
        System.out.println(list);
    }

    /**
     * Sets.cartesianProduct(set, set1); //求两个集合的笛卡尔乘积
     */
    @Test
    public void test11(){
        Set<String> set = Sets.newHashSet("111", "222", "333");
        Set<String> set1 = Sets.newHashSet("444", "555", "666");
        Set<List<String>> cartesianProduct = Sets.cartesianProduct(set, set1); //求两个集合的笛卡尔乘积
        List<List<String>> list = Lists.newArrayList(cartesianProduct);
        for (List<String> listInside : list) {
            for (String s : listInside) {
                System.out.println(s);
            }
            System.out.println("------------");
        }
    }

    /**
     * 完全的组合 Lists.newArrayList
     */
    @Test
    public void test12(){
        Set<String> set = Sets.newHashSet("111", "222", "333");
        Set<Set<String>> sets = Sets.powerSet(set);
        List<Set<String>> list = Lists.newArrayList(sets);
        for (Set<String> setInside : list) {
            List<String> listInside = Lists.newArrayList(setInside);
            for (String s : listInside) {
                System.out.println(s);
            }
            System.out.println("--------");
        }
    }

    /**
     * Maps.newHashMap
     */
    @Test
    public void test13(){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("username","zhangsan");
        map1.put("password","123456");
        Map<String, Object> map = Maps.newHashMap(map1); //初始化Map
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("-------------");
        }
    }

    /**
     * 创建HashMap实例，并使用匿名内部类 + 构造块完成初始化元素
     */
    @Test
    public void test14(){
        //外层括号是匿名内部类 相当于定义了一个类，实现了HashMap接口
        //内层括号是构造块，相当于在匿名内部类中写了一个构造块，那么执行这个类的时候，就会取执行构造代码块
        //一个类中的执行顺序，先执行静态代码块，然后执行空参构造方法，然后执行构造块，最后执行调用的方法。
        Map<String,Object> map1 = new HashMap<String,Object>(){
            {
                //方法里面使用匿名内部类使用到外部的成员，外部成员必须经过初始化才行，毕竟无法去更改
                put("username","123");
            }
        };
        //这里相当于就是实例化出来了map1对象，然后map1去调用put方法的呢
        System.out.println(map1.get("username"));
    }

    /**
     * 在方法中，匿名内部类的代码块中使用到外部变量，使用基本类型必须经过初始化，无法去更改基本类型的值
     */
    @Test
    public void test15(){
        String s = "password";
        String temp = "temp";
        Integer num = 1;
        UserParam userParam = new UserParam();
        userParam.setPassword("780780");
        //使用filter 试一下
        Map<String,Object> map1 = new HashMap<String,Object>(){
            {
                put("username","123");
                put(s,userParam.getPassword());
                userParam.setId("111");
                System.out.println(temp);
            }
        };
        System.out.println("ID：" + userParam.getId());
        System.out.println("password：" + userParam.getPassword());
    }

    /**
     * 初始化两个list，一个执行filter，然后当里面满足某个表达式，另一个list进行操作
     * lambda表达式其实就是匿名内部类的简写形式，原来filter里面是有一个接口Predicate需要去创建这个对象，但是我们如果使用匿名内部类去实现的话，那么需要去new Predicate(){ @Override 方法签名+方法体 };
     * 使用了lambda表达式的话，可以省去new Predicate(){} 整个外层 还有 里面的方法返回值 + 方法名
     * 只需要写参数括号加方法体即可 使用方式 e -> {}
     * 如果方法体的代码只有一行的话，那么可以不用写{} + return + ; 这些东西
     * 特殊情况下还可以使用方法引用的方式
     */
    @Test
    public void test16(){

        List<String> list = Lists.newArrayList("111");
        List<String> list1 = Lists.newArrayList();
        List<String> list2 = list.stream().filter(e -> {
            System.out.println(e.equals("111"));
            if (e.equals("111")){
                list1.add(e);
                return false; //遍历e的时候，如果遇到该方法体中是return true的话，那么这个e的值就会经过流式处理后保存下来
            }
            System.out.println("测试是否执行这里？");
            return false;
        }).collect(Collectors.toList());
        System.out.println(list1); //测试看看是否可以


    }

    /**
     *  测试使用方法引用去调本类的方法
     */
    @Test
    public void test17(){

        List<String> list = Lists.newArrayList("111");
        List<String> list2 = list.stream().filter(e -> {
            System.out.println(e.equals("111"));
            if (e.equals("111")){
                this.test18();
                return false; //遍历e的时候，如果遇到该方法体中是return true的话，那么这个e的值就会经过流式处理后保存下来
            }
            return false;
        }).collect(Collectors.toList());

    }

    private static void test18(){
        System.out.println("test18打印");
    }

    /**
     *
     */
    @Test
    public void test19(){
    }


}
