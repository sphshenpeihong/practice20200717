package com.sph.practice.test.markdown.designPattern.builder;

/**
 * Created by Shen Peihong on 2020/11/25 22:16
 * Description: 指挥者 负责组装步骤， 需要有一个方法是返回产品的
 *
 * @since 1.0.0
 */
public class HouseDirector {

    //需要用到建造者的方法，故依赖建造者类，定义成成员变量
    private AbstractHouseBuilder houseBuilder;

    //构造方法注入
    public HouseDirector(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //set方法注入
    public void setHouseBuilder(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House getHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildRoofed();
        houseBuilder.buildWall();
        return houseBuilder.buildHouse();
    }

}
