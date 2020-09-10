package com.sph.practice.test.sebase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shen Peihong on 2020/8/12 18:17
 * Description:测试Pattern 和 Matcher两个类的使用
 *
 * @since 1.0.0
 */
public class PatternAndMatcher {

    private String abc = "abc";

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    /**
     * 简单的Pattern和Matcher
     */
    @Test
    public void test1() {
        String regex = "java";
        String test = "eejavaee";
        //新建匹配规则
        Pattern pattern = Pattern.compile(regex);
        //下面进行匹配，matcher是匹配后的结果对象
        Matcher matcher = pattern.matcher(test);
        //若找到与匹配规则相同的话
        if (matcher.find()) {
            //返回匹配上的字符串
            System.out.println(matcher.group(0));
        }
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list = null;
        /*List<String> filter = list.stream().filter(k -> k.equals("111")).collect(Collectors.toList());
        System.out.println(filter);*/
        System.out.println(list.isEmpty());
    }

    @Test
    public void test11() {
        String flag;
        List<String> list = new ArrayList<>();
        list.add("123");
        List<String> list1 = new ArrayList<>();
        list.add("1234");
        list1.stream().forEach(e-> System.out.println("123213"));
    }

    static class A{
        public static void main(String[] args) {
            PatternAndMatcher p = new PatternAndMatcher();
            System.out.println("4343434");
            System.out.println(p.abc);
        }
    }
}
