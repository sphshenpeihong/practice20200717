package com.sph.practice.test.innerclass;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class OutClass {
    public static int count = 12;
    private double radius;

    public OutClass(double radius) {
        this.radius = radius;
    }

    public static void main() {
        OutClass out = new OutClass(1.2);
        InnerClass inner = out.new InnerClass();
        inner.test();//内部类⽅法
        inner.name = "my test";//内部类属性
    }

    // 内部类1
    public static class InnerClass1 {
        private final static String str = "123";
    }

    public class InnerClass {//内部类
        public String name = "test";

        public void test() {
            System.out.println(count);//访问外部类成员
            System.out.println(radius);//访问外部类成员
        }
    }
}
