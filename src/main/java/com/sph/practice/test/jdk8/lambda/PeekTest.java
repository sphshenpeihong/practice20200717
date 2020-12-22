package com.sph.practice.test.jdk8.lambda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sph.practice.test.bean.AccountPO;
import com.sph.practice.test.bean.ForeachVO;
import com.sph.practice.test.jdk8.lambda.vo.AClass;
import com.sph.practice.test.jdk8.lambda.vo.ListContainer;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shen Peihong on 2020/12/22 14:04
 * Description:
 *
 * @since 1.0.0
 */
public class PeekTest {

    /**
     *
     */
    @Test
    public void test1(){
        AccountPO po1 = new AccountPO(1, "zhangsan", "zhangsan");
        AccountPO po2 = new AccountPO(2, "lisi", "lisi");
        List<AccountPO> list = Lists.newArrayList();
        list.add(po1);
        list.add(po2);
        //使用peek修改其中的元素username
        list.forEach(System.out::println);
        System.out.println("==========");
        List<AccountPO> afterList = list.stream().peek(po -> po.setUsername("xiesi")).collect(Collectors.toList());
        System.out.println("==========");
        list.forEach(System.out::println);
        System.out.println("==========");
        afterList.forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void test2(){
        AccountPO po1 = new AccountPO(1, "zhangsan", "zhangsan");
        AccountPO po2 = new AccountPO(2, "lisi", "lisi");
        List<AccountPO> list = Lists.newArrayList();
        list.add(po1);
        list.add(po2);
        //使用peek修改其中的元素username
        list.forEach(System.out::println);
        System.out.println("==========");
        list.forEach(po -> po.setUsername("xiesi"));
        System.out.println("==========");
        list.forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void test3(){
        //第一个元素
        AccountPO accountPO1 = new AccountPO(1,"zhangsan","zhangsan");
        AccountPO accountPO2 = new AccountPO(2,"lisi","lisi");
        List<AccountPO> accountPOList1 = Lists.newArrayList();
        accountPOList1.add(accountPO1);
        accountPOList1.add(accountPO2);

        ForeachVO foreachVO1 = new ForeachVO();
        foreachVO1.setId("1");
        foreachVO1.setAccountPOList(accountPOList1);


        //第二个元素
        AccountPO accountPO3 = new AccountPO(3,"wangwu","wangwu");
        AccountPO accountPO4 = new AccountPO(4,"zhaoliu","zhaoliu");
        List<AccountPO> accountPOList2 = Lists.newArrayList();
        accountPOList2.add(accountPO3);
        accountPOList2.add(accountPO4);

        ForeachVO foreachVO2 = new ForeachVO();
        foreachVO2.setId("1");
        foreachVO2.setAccountPOList(accountPOList2);



        //整个到list
        List<ForeachVO> list = Lists.newArrayList();
        list.add(foreachVO1);
        list.add(foreachVO2);

        //遍历VO的List，然后修改VO里面成员变量List的某个值
        list.stream().peek(VO -> {
            VO.setId(UUID.randomUUID().toString());
                VO.getAccountPOList().stream().forEach(PO -> PO.setUsername(VO.getId()));
        }).collect(Collectors.toList());

        System.out.println("========");
        //最后遍历修改完的呢
        for (ForeachVO foreachVO : list) {
            List<AccountPO> accountPOList = foreachVO.getAccountPOList();
            for (AccountPO accountPO : accountPOList) {
                System.out.println(accountPO);
            }
        }

        //日期转String 不重新定义试试

    }

    /**
     *
     */
    @Test
    public void test4(){
        /*AccountPO po1 = new AccountPO(1, "zhangsan", "zhangsan");
        AccountPO po2 = new AccountPO(2, "lisi", "lisi");
        List<AccountPO> list = Lists.newArrayList();
        list.add(po1);
        list.add(po2);
        list.stream().flatMap(PO -> Lists.newArrayList().stream()).collect(Collectors.toList());*/
        List<String> list = Lists.newArrayList();
        list.add("123");
        list.add("456");
        List<String[]> collect = list.stream().map(str -> str.split("")).collect(Collectors.toList());
        for (String[] strings : collect) {
            System.out.println(Arrays.asList(strings));
        }

    }

    /**
     * 操作日历的相加减，
     */
    @Test
    public void test5(){
        //Calendar 日期前后
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR, -2);
        Date nowTime = now.getTime();
        //格式化一下
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(nowTime);
        System.out.println(format);

    }

    /**
     * 日期类型转String类型
     */
    @Test
    public void test6(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //两小时前
        Calendar before = Calendar.getInstance();
        before.add(Calendar.HOUR, -2);
        Date beforeTime = before.getTime();

        //现在
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR, 0);
        Date nowTime = now.getTime();

        //两小时后
        Calendar after = Calendar.getInstance();
        after.add(Calendar.HOUR, 2);
        Date afterTime = after.getTime();



        List<Date> dateList = new ArrayList<Date>() {{
            add(beforeTime);
            add(nowTime);
            add(afterTime);
        }};

        System.out.println(dateList);

        List<String> strList = dateList.stream().map(date -> sdf.format(date)).collect(Collectors.toList());

        System.out.println(strList);
    }

    /**
     * list
     */
    @Test
    public void test7(){
        List<String> list = Lists.newArrayList();
        list.add("123");
        list.add("456");
        //获取流对象 方法一
        Stream<String> stream = list.stream();

        //方法二 利用Stream类提供的方法
        Stream<String> list1 = Stream.of("123","456");
        list1.forEach(System.out::println);
    }

    /**
     * 单词去重
     */
    @Test
    public void test8(){
        String[] strArray = {"hello", "world"};
        //List<String>类型 -> List<String[]>类型 遍历每个String[]的时候 又使用Arrays.stream()方法 将数组转换成Stream流对象
        List<Object> collect = Arrays.asList(strArray).stream().map(word -> word.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     *
     */
    @Test
    public void test9(){
        List<String> list = Lists.newArrayList();
        list.add("123");
        list.add("456");
        //获取list的流对象
        Stream<String> stream = list.stream();
    }

    /**
     *
     */
    @Test
    public void test10(){
        List<String> list1 = Lists.newArrayList();
        list1.add("123");
        List<String> list2 = Lists.newArrayList();
        list1.add("456");
        List<String> list = Lists.newArrayList();
        list.addAll(list1);
        list.addAll(list2);
        System.out.println(list);

    }

    @Test
    public void mergeMapValuesTest(){
        Map<Integer, ListContainer> map = Maps.newHashMap();

        //成员变量
        List<AClass> aClassList1 = Lists.newArrayList();
        AClass aClass = new AClass(1, "zhuoli1", "haha1");
        aClassList1.add(aClass);
        aClassList1.add(new AClass(2, "zhuoli2", "haha2"));
        aClassList1.add(new AClass(3, "zhuoli3", "haha3"));

        //成员变量
        List<AClass> aClassList2 = Lists.newArrayList();
        aClassList2.add(aClass);
        aClassList2.add(new AClass(5, "zhuoli5", "haha5"));
        aClassList2.add(new AClass(6, "zhuoli6", "haha6"));

        /*交集*/
        /*[AClass(id=1, name=zhuoli1, description=haha1)]*/
        List<AClass> intersectResult = aClassList1.stream().filter(aClassList2::contains).collect(Collectors.toList());
        System.out.println(intersectResult);

        /*并集*/
        List<AClass> unionResult = Stream.of(aClassList1, aClassList2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        if (unionResult.size() == 5){
            System.out.println("等于5");
        }
        System.out.println(unionResult);

        /*差集*/
        /*[AClass(id=2, name=zhuoli2, description=haha2), AClass(id=3, name=zhuoli3, description=haha3)]*/
        List<AClass> differenceResult = aClassList1.stream().filter(x -> !aClassList2.contains(x)).collect(Collectors.toList());
        System.out.println(differenceResult);

        map.put(1, new ListContainer(aClassList1));
        map.put(2, new ListContainer(aClassList2));

        /*合并多个list*/
        List<AClass> aClassListResult = map.values().stream().flatMap(listContainer -> listContainer.getLst().stream()).collect(Collectors.toList());
        /*注意跟并集的区别*/
        if (aClassListResult.size() == 6 ){
            System.out.println("等于6");
        }
        System.out.println(aClassListResult);
    }

    /**
     * contain 地址
     */
    @Test
    public void test11(){
        List<AClass> list1 = new ArrayList<>();
        AClass aClass1 = new AClass();
        aClass1.setId(1);
        System.out.println(aClass1);
        System.out.println(aClass1.hashCode());
        System.out.println("===========");
        list1.add(aClass1);
        AClass aClass2 = new AClass();
        aClass2.setId(1);
        System.out.println(aClass2);
        System.out.println(aClass2.hashCode());
        System.out.println(aClass1==aClass2);
        System.out.println("===========");
        System.out.println(list1.contains(aClass2));
    }

    /**
     *
     */
    @Test
    public void test12(){
        //静态方法用list好像有问题 数组试试 数组里面没有stream() 方法 所以如果要搞个数组的话，只能用静态方法了
        List<String> list1 = Lists.newArrayList();
        list1.add("111");
        list1.add("222");

        List<String> list2 = Lists.newArrayList();
        list2.add("333");
        list2.add("444");

        //两个list一起秀操作
        //首先获取流式对象，两个list 流式对象泛型是List类型的呢
        //Stream.of(list1,list2).


    }

    /**
     * 一个成员变量里面有List类型，现在是专门要对成员变量的List类型进行各种判断，筛选 筛选符合条件 留下来的，不符合的直接要去除掉
     */
    @Test
    public void test13(){
        String[] strArray = {"hello", "world"};
        List<String> list = Lists.newArrayList("123", "456");
        Stream.of(list).flatMap(Collection::stream).collect(Collectors.toList());
    }

    /**
     * 定义一个Stream<LIst<String>> 操作先
     */
    @Test
    public void test14(){
        List<List<String>> list = new ArrayList<>();

        List<String> innerList1 = Lists.newArrayList();
        innerList1.add("111");
        innerList1.add("222");

        List<String> innerList2 = Lists.newArrayList();
        innerList2.add("333");
        innerList2.add("444");

        list.add(innerList1);
        list.add(innerList2);
        //多个List 流式对象的类型就是List类型 然后flatMap就是对每个List类型的Stream流式对象 进行转化 有点类似于一开始对List进行流式处理的感觉，只不过又多前了一层而已
        //使用了flatMap方法后 就获得了内层的流式对象了，就可以和平常那样再继续进行操作了。
        //所以一般有嵌了两层的话，内层是List或数组，都可以进行处理
        List<String> collect = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);
    }


}
