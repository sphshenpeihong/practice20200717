package com.sph.practice.test.markdown.designPattern.prototype;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created by Shen Peihong on 2020/11/23 22:28
 * Description: clone
 *
 * @since 1.0.0
 */
public class Sheep implements Cloneable {
    //静态变量也可以去调用实例方法

    private String name;
    private String age;
    private Sheep sheep;

    public Sheep(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sheep=" + sheep +
                '}';
    }

    //使用原型模式去获取实例
    public Sheep clone() throws CloneNotSupportedException {
        return (Sheep)super.clone();
    }
}

class Test1{


    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("1","1");
        sheep.setSheep(new Sheep("2","2"));
        Sheep clone = sheep.clone();
        System.out.println(sheep.hashCode());
        System.out.println(clone.hashCode());
        /*
            1792393294
            1748225580
         */
        System.out.println(sheep.getSheep().hashCode());
        System.out.println(clone.getSheep().hashCode());
        /*
            1918627686
            1918627686
         */
    }

}
