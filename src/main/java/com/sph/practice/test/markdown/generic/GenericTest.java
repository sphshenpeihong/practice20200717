package com.sph.practice.test.markdown.generic;

import com.google.common.collect.Lists;
import com.sph.practice.test.param.BankVO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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



}
