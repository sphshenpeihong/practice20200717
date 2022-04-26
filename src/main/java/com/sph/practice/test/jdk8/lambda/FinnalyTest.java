package com.sph.practice.test.jdk8.lambda;

import com.google.common.collect.Lists;
import com.sph.practice.test.jdk8.lambda.vo.CalculateVO;
import com.sph.practice.test.jdk8.lambda.vo.LearnonlineVO;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/12/23 13:44
 * Description: 终结方法
 * 终端操作时流式处理的最后一步，我们可以在终端操作中实现对流查找、归约等操作
 *
 * @since 1.0.0
 */
public class FinnalyTest {

    List<String> list11 = new ArrayList<String>() {
        {
            this.add("123");
            this.add("456");
        }
    };

    /**
     * allMatch 遍历的元素全部都匹配条件
     */
    @Test
    public void test1() {
        List<String> list = new ArrayList<String>() {
            {
                add("123");
                add("456");
            }
        };
        //遍历的数据是否长度都为3
        boolean allMatch = list.stream().allMatch(k -> k.length() == 3);
        System.out.println(allMatch);
        /*
            true
         */
    }

    /**
     * anyMatch 遍历的元素存在局部满足条件
     */
    @Test
    public void test2(){
        List<String> list = new ArrayList<String>() {
            {
                add("123");
                add("456666");
            }
        };
        //遍历的数据是否局部满足长度为3
        boolean anyMatch = list.stream().anyMatch(k -> k.length() == 3);
        System.out.println(anyMatch);
        /*
            true
         */
    }

    /**
     * noneMatch 遍历的元素全都不满足条件
     */
    @Test
    public void test3(){
        List<String> list = new ArrayList<String>() {
            {
                add("1234");
                add("456666");
            }
        };
        //遍历的数据是否局部满足长度为3
        boolean noneMatch = list.stream().noneMatch(k -> k.length() == 3);
        System.out.println(noneMatch);
        /*
            true
         */
    }

    /**
     * findFirst 返回流式处理完后的第一个元素
     */
    @Test
    public void test4() {
        List<String> list = new ArrayList<String>() {
            {
                add("123");
                add("456");
            }
        };
        Optional<String> first = list.stream().filter(k -> k.length() == 3).findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }
    }

    /**
     * findAny 返回流式处理后的任意一个元素
     */
    @Test
    public void test5(){
        List<String> list = new ArrayList<String>() {
            {
                add("621");
                add("000");
                add("123");
                add("456");
                add("789");
            }
        };
        Optional<String> findAny = list.stream().filter(k -> k.length() == 3).findAny();
        if (findAny.isPresent()) {
            System.out.println(findAny.get());
        }
    }

    /**
     * 直接一个int数组做累加
     */
    @Test
    public void test6() {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        Integer sum = (Integer)list.stream().collect(Collectors.summingInt(k -> k));
        System.out.println(sum);
    }

    //分组求和，groupingBy的第二个参数可以指定分组后的数据的 其他实现方式
    /**
     * 分组求和
     */
    @Test
    public void test7(){
        List<CalculateVO> list = new ArrayList<CalculateVO>(){
            {
                add(new CalculateVO(1, 3, 2));
                add(new CalculateVO(2,1, 1));
                add(new CalculateVO(3,5, 2));
                add(new CalculateVO(4,3, 1));
            }
        };
        Map<Integer, Integer> collect = list.stream().collect(Collectors.groupingBy(CalculateVO::getParentId, Collectors.summingInt(CalculateVO::getNum)));
        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("=======");
        }
    }

    /**
     * 分组求平均值
     */
    @Test
    public void test8(){
        List<CalculateVO> list = new ArrayList<CalculateVO>(){
            {
                add(new CalculateVO(1, 3, 2));
                add(new CalculateVO(2,1, 1));
                add(new CalculateVO(3,6, 2));
                add(new CalculateVO(4,3, 1));
            }
        };
        Map<Integer, Optional<CalculateVO>> collect = list.stream().collect(Collectors.groupingBy(CalculateVO::getParentId, Collectors.maxBy((v1, v2) ->  v1.getNum() -  v2.getNum())));
        for (Map.Entry<Integer, Optional<CalculateVO>> entry : collect.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("=======");
        }
    }

    //collect()是终结方法，形参支持接受Collector接口类型
    //故可以对经过流式处理的数据进行各种操作，比如如果是数值型的话，支持求和，求最值，平均值等
    //如果是类类型的话，也支持进行各种条件进行分组，也支持分组过后进行分组求和或求最值，平均值等
    //其中类类型也支持转成Map

    /**
     * 对流式处理后的数据进行二重分组
     */
    @Test
    public void test9(){
        //准备一批测试数据
        //两场考试
        String exam1 = this.getUUID();
        String exam2 = this.getUUID();
        //两份试卷
        String testpaper1 = this.getUUID();
        String testpaper2 = this.getUUID();
        //三道题目
        String section1 = this.getUUID();
        String section2 = this.getUUID();
        String section3 = this.getUUID();

        //初始化相关VO类信息
        LearnonlineVO VO1 = new LearnonlineVO(1, exam1, "考试1号", testpaper1, "试卷1号", section1, "题目1号");
        LearnonlineVO VO2 = new LearnonlineVO(2, exam1, "考试1号", testpaper1, "试卷1号", section2, "题目2号");
        LearnonlineVO VO3 = new LearnonlineVO(3, exam2, "考试2号", testpaper2, "试卷2号", section1, "题目1号");
        LearnonlineVO VO4 = new LearnonlineVO(4, exam2, "考试2号", testpaper1, "试卷1号", section1, "题目1号");
        LearnonlineVO VO5 = new LearnonlineVO(5, exam1, "考试1号", testpaper2, "试卷2号", section3, "题目3号");

        List<LearnonlineVO> list = new ArrayList<LearnonlineVO>() {
            {
                add(VO1);
                add(VO2);
                add(VO3);
                add(VO4);
                add(VO5);
            }
        };
        //二重分组(先对考试ID分组，再对Map的Value再进一步对试卷ID进行分组)
        Map<String, Map<String, List<LearnonlineVO>>> collect = list.stream().collect(
                Collectors.groupingBy(LearnonlineVO::getExamId, Collectors.groupingBy(LearnonlineVO::getTestpaperId))
        );
    }

    private String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 并行流
     */
    @Test
    public void test10(){
        List<String> list = Lists.newArrayList("111", "222", "333");
        List<String> collect = list.parallelStream().collect(Collectors.toList());
        System.out.println(collect);
    }

}
