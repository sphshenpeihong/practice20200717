package com.sph.practice.test.innerclass;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class OuterClassDemo {

    public void test() {
        class InnerClass {
            final static String test = "1";
            private String name;

            public InnerClass(String name) {
                super();
                this.name = name;
            }

            public void say(String str) {
                System.out.println(name + ":" + str);
            }
        }
        new InnerClass("test").say("hello");
    }
}
