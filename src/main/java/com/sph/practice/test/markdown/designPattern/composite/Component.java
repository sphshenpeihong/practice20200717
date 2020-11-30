package com.sph.practice.test.markdown.designPattern.composite;

/**
 * Created by Shen Peihong on 2020/11/28 19:47
 * Description: 组合模式，包含的关系
 *
 * @since 1.0.0
 */
public abstract class Component {

    private String name;
    private String desc;

    public Component(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //提供添加方法
    public void add(Component component){
    }

    //提供删除方法
    public void remove(Component component){

    }

    //提供打印方法
    public void print(){

    }

}
