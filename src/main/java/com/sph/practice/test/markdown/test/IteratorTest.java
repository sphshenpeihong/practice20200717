package com.sph.practice.test.markdown.test;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * Created by Shen Peihong on 2020/10/20 21:39
 * Description:
 *
 * @since 1.0.0
 */
@Slf4j
public class IteratorTest {

    private List<String> filterList = Lists.newArrayList();

    /**
     * 迭代器demo
     */
    @Test
    public void test(){
        List<String> list = Lists.newArrayList();
        list.add("111");
        list.add("222");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("111".equals(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(list);
        /*
            [222]
         */
        //使用了迭代器，那么就相当于使用的是引用地址，当迭代器元素改变时，同时也会改变原list
    }

    /**
     *
     */
    @Test
    public void test1(){
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("username", "zhangsan");
                put("password", "123456");
            }
        };
        log.info("123123");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("当前的key为：" + entry.getKey() + "| 所对应的value为：" + entry.getValue());
        }
        /*
            当前的key为：password| 所对应的value为：123456
            当前的key为：username| 所对应的value为：zhangsan
         */
    }

    // 迭代器是否按顺序
    /**
     *
     */
    @Test
    public void test2(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("111");
        strings.add("222");
        strings.add("34");
        strings.add("12");
        Iterator<String> iterator = strings.iterator();
        int currentIndex = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(currentIndex);
            ++currentIndex;
        }
    }

}
