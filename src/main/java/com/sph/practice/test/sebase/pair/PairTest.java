package com.sph.practice.test.sebase.pair;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen Peihong on 2021/1/3 0:08
 * Description: 使用以下Pair类，里面的成员变量只有两个，都是利用泛型类去指定的，和HashMap里面的Node是思想一样的呢。
 * Map的话，它的值是一个一个键值对来的，其实是自己本身定义了一个Node<K, V>[] 数组类型的成员变量，然后Node类型是自己的一个静态内部类，变量自己决定
 * Pair和Map的区别呢，比方我们现在硬是要使用一个List类型去存储，然后也希望每个值都是一个键值对来的，和Map思想一样，那我们就可以声明泛型为一个
 * 键值对类型，键值对类型的话，需要具备两个值 一个是Key 一个是Value呢，Pair就帮我们提供了呢。
 *
 * @since 1.0.0
 */
public class PairTest {

    /**
     *
     */
    @Test
    public void test(){
        List<Pair<String, Object>> list = new ArrayList<Pair<String, Object>>(){
            {
                add(new Pair<>("username", "zhangsan"));
                add(new Pair<>("password", "123456"));
            }
        };
        //用Map<String, Object> 和 List<Pair<String, Object>>的区别
        //相同点：遍历的时候，都是遍历键值对呢
        //不同点：获取键值对的方式不同，Map的话，获取的时候，需要通过key获取对应的value
        //但是List的话，是要先通过下标去获取呢
        list.forEach(System.out::println);
    }

}
