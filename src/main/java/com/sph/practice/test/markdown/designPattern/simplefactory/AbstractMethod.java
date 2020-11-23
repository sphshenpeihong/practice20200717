package com.sph.practice.test.markdown.designPattern.simplefactory;

/**
 * Created by Shen Peihong on 2020/11/22 11:07
 * Description:
 *
 * @since 1.0.0
 */
public abstract class AbstractMethod {

    //定义一个抽象方法
    public abstract void execute();
    //定义一个抽象方法
    //或者是子类对象已实例化，只要声明类型是向上转型的话，那么当调用这个方法的时候，都会去调当前实例化子类的方法
    //只有子类才能声明成当前抽象类的类型，否则就不行
    public abstract void diaoyong();

    public AbstractMethod() {
        System.out.println("测试子类是否可以继承父类构造器");
        //调用抽象方法

        execute();  //代码执行到这里的话，肯定是有对象调用到了这个方法，这里是构造器，那么只有子类去实例化对象的时候，才会调到父类的构造器
    }


}

class Method1 extends AbstractMethod{
    //子类构造器第一行就是super.父类的构造器的

    public Method1(){
        //所以说无论如何，调用子类的构造器的话，一定会去调到父类的构造器的
        System.out.println("不信我就搭一打");
    }

    @Override
    public void execute() {
        System.out.println("Method1");
    }

    @Override
    public void diaoyong() {
        System.out.println("diaoyong");
    }
}

class Test2{

    public static void main(String[] args) {
        AbstractMethod method1 = new Method1();
        method1.diaoyong();
    }
}

class Test3{

    //不实例化子类，直接通过lambda表达式去实例抽象类
    public static void main(String[] args) {
        AbstractMethod abstractMethod = new AbstractMethod() {
            @Override
            public void execute() {
                System.out.println("嘿嘿execute1");
            }

            @Override
            public void diaoyong() {
                System.out.println("diaoyong");

            }
        };
        abstractMethod.execute();
    }
}
