package com.sph.practice.test.abstractAndImplements;

/**
 * Created by Shen Peihong on 2020/9/13 16:14
 * Description:
 *
 * @since 1.0.0
 */
public class Cat extends Animal {
    /*
        子类继承了父类，若使用多态的方式去声明对象时，那么向上转型后就是父类类型，调方法的时候，都会去调父类的方法，到了父类那一层，会判断子类是否存在同个签名的方法，若有的话直接调子类的方法
        无法直接去调子类有，而父类没有的方法，因为类型都说明了调不到子类特有的方法，但是可以调父类有而子类没有的方法。
        父类声明了抽象方法，子类必须去实现该抽象方法。这样一来，利用多态声明类型是父类类型后，当调用此方法时，调用的直接就是实例化子类的同签名的方法了。
        //无论子类继承的方法是否抽象，每次父类对象调用方法时，都会先去优先去子类看看是否有，有的话会直接调用子类的方法。实在没有的话，才会直接调父类的方法，若所调方法父类没有，则直接编译报错。
     */

    @Override
    String getContent() {
        return "test";
    }


    String parentTest1(){
        return "sonTest1";
    }
}
