package com.sph.practice.test.markdown.designPattern.builder;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/25 22:21
 * Description: 客户自己按自己的想法去建房子
 *
 * @since 1.0.0
 */
public class Client {

    /**
     *
     */
    @Test
    public void test(){
        //新建指挥者对象，因为需要利用指挥者对象去造房子
        //指挥者依赖了建造者对象，所以需要set了才能用，因为依赖的该对象，去调用了方法了
        //如果不实例化该对象，直接使用的话，就会出现空指针异常了
        AbstractHouseBuilder commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        houseDirector.getHouse();
    }

    /**
     * 用一下子类的构造方法 static 构造块 构造方法 的加载顺序 父 子 类
     */
    @Test
    public void test1(){
        CommonHouse commonHouse = new CommonHouse();
    }

}
