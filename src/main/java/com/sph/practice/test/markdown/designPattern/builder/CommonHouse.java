package com.sph.practice.test.markdown.designPattern.builder;

/**
 * Created by Shen Peihong on 2020/11/25 22:14
 * Description: 具体房子的类型，只需要继承建造者抽象类(抽象类里面定义了建造房子的步骤 定义成抽象方法，由继承子类去重写)
 *
 * @since 1.0.0
 */
public class CommonHouse extends AbstractHouseBuilder {

    public CommonHouse(){
        super();
        System.out.println("我是子类的构造方法");
    }

    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildRoofed() {
        System.out.println("普通房子盖屋顶");
    }

    @Override
    public void buildWall() {
        System.out.println("普通房子砌墙");
    }


}
