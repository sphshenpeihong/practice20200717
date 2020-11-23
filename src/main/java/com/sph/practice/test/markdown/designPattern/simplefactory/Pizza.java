package com.sph.practice.test.markdown.designPattern.simplefactory;

/**
 * Created by Shen Peihong on 2020/11/22 9:19
 * Description: 定义一个披萨类，披萨类有很多种类，可以利用多态还实例化不同种类的披萨
 *
 * @since 1.0.0
 */
public abstract class Pizza {

    //定义制作原材料的方法 (不同种类的实现步骤是不一样的，直接定义一个抽象方法，子类去重写即可)
    public abstract void prepare();

    //定义烘焙的方法(过程一样的话，直接写方法，子类可以直接调用)
    public void bake(){
        System.out.println("进行烘焙");
    }

    //定义打包的方法
    public void pack(){
        System.out.println("进行打包");
    }

}
