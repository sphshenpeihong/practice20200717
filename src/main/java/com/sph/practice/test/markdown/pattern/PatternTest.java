package com.sph.practice.test.markdown.pattern;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shen Peihong on 2020/10/29 14:51
 * Description:正则表达式
 *
 * @since 1.0.0
 */
public class PatternTest {

    /**
     * Pattern和Matcher结合使用
     */
    @Test
    public void test1(){
        //这里可以使用各种正则表达式
        String regex = "java";
        String test = "eejavaeejavaee";
        //新建匹配规则对象
        Pattern pattern = Pattern.compile(regex);
        //匹配结果对象
        Matcher matcher = pattern.matcher(test);
        //将匹配到的字符串全替换
        String str = matcher.replaceAll("");
        System.out.println(str);
        /*
            eeeeee
         */
        //若找到与匹配规则相同的话
        if (matcher.find()){
            System.out.println("已匹配上");
        }
    }

}
