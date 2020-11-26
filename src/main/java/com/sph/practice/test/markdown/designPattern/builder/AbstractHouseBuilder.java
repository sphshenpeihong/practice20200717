package com.sph.practice.test.markdown.designPattern.builder;

/**
 * Created by Shen Peihong on 2020/11/25 22:10
 * Description: 建造者抽象类
 *
 * @since 1.0.0
 */
public abstract class AbstractHouseBuilder {

    public AbstractHouseBuilder(){
        System.out.println("我是父类的构造方法");
    }

    //最终结果是一个产品
    private House house;

    //打地基
    public abstract void buildBasic();

    //盖屋顶
    public abstract void buildRoofed();

    //砌墙
    public abstract void buildWall();

    //返回具体的产品
    public House buildHouse(){
        return this.house;
    }

}
