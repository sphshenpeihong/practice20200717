package com.sph.practice.test.markdown.generic;

import com.google.common.collect.Lists;
import com.sph.practice.test.bean.MulpartStateVO;
import com.sph.practice.test.param.BankVO;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/11/16 20:14
 * Description:
 *
 * @since 1.0.0
 */
public class GenericTest {

    /**
     * 泛型方法如果不加通配符的话，那么和Object类型的方法没啥区别
     */
    @Test
    public void test1(){
        GenericClass c1 = new GenericClass();
        BankVO bankVO = new BankVO();
        bankVO.setId("1");
        c1.setData(bankVO);
        System.out.println(c1.getData());
    }

    //定义一个泛型方法，看看声明约束到形参，会不会约束到返回值

    <T extends Collection> T getData(T t){
        return t;
    }

    /**
     *
     */
    @Test
    public void test2(){
        //System.out.println(getData("1123"));
    }

    //书写一个泛型方法，用于校验各种基本类型的参数是否为空
    public <T> boolean isEmpty(T t) throws Exception {
        if (t instanceof String) {
            return t.equals("") || t == null;
        } else if (t instanceof Collection) {
            return ((Collection) t).isEmpty() || t == null;
        } else if (t instanceof Map) {
            return ((Map) t).isEmpty() || t == null;
        } else {
            throw new Exception("该类型不支持判空");
        }
    }

    /**
     * 调用泛型方法
     */
    @Test
    public void test3() throws Exception {
        List<Object> list = Lists.newArrayList();
        System.out.println(this.isEmpty(list));
    }

    //测试toMap表达式
    @Test
    public void test4(){
        List<MulpartStateVO> list = new ArrayList<MulpartStateVO>() {{
            add(new MulpartStateVO(1,1));
            add(new MulpartStateVO(2,2));
            add(new MulpartStateVO(3,1));
            add(new MulpartStateVO(4,2));
            add(new MulpartStateVO(5,3));
        }};
        Map<String, MulpartStateVO> map = list.stream().collect(Collectors.toMap(k -> {
            return k.getId() + ":" + k.getState();
        }, k -> k));



        //遍历map
        for (Map.Entry<String, MulpartStateVO> entry : map.entrySet()) {
            System.out.println("当前key为：" + entry.getKey() + "，对应的value为：" + entry.getValue());
        }
        //static 单例模式
        //static 直接声明 + 赋值的话，那么直接类加载的时候，就会直接存放到方法区中

        //单例模式的话，类加载的时候，会先是加载 引用变量到方法区，然后等到调用获取单例实例的时候，才会去判断方法区这个引用值是否为空，一系列判断再进行初始化，达到单例 + 懒加载的效果


        new Thread(() -> {

        }).start();
    }
    //单例模式：定义一个类，但是该类构造方法私有化 然后只提供一个获取实例的方法
    //懒加载 + 单个实例 (这个static变量本身就是单实例了)

    /**
     *
     */
    @Test
    public void test6(){
        System.out.println(StaticClass.userPO.hashCode());
        System.out.println(StaticClass.userPO.hashCode());
    }
}
