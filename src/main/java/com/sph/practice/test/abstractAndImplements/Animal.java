package com.sph.practice.test.abstractAndImplements;

/**
 * Created by Shen Peihong on 2020/9/13 16:14
 * Description:
 *
 * @since 1.0.0
 */
public abstract class Animal {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //统一对外输出方式接口
    public void say(){
        this.getContent();
    }

    //实例化子类时，声明成父类
    //定义抽象方法，子类继承父类，则需要实现该方法
    abstract String getContent();

    String parentTest1(){
        return "parentTest1";
    }

}
