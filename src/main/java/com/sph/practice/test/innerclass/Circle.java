package com.sph.practice.test.innerclass;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class Circle {
    public static int count = 1;
    private double radius = 0.0;
    private String username;

    public Circle(double radius) {
        this.radius = radius;
    }

    public class Draw {//内部类
        private double radius = 1.1;

        public void drawSahpe() {
            System.out.println(Circle.this.radius);
            System.out.println(radius);//外部类的private成员
            System.out.println(count);//外部类的静态成员
        }
    }
}
