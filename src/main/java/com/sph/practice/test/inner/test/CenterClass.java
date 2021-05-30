package com.sph.practice.test.inner.test;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
public class CenterClass {

    private String examId = "examId";


    static class staticInnerClass {
        private String subjectId = "subjectId";

        // 静态方法无法引用成员变量
        void test() {
            System.out.println(subjectId);
        }

        static void staticTest() {
            System.out.println("staticTest");
        }

    }

    class InnerClass {

        private String answerId = "answerId";

        void innerTest() {

        }


    }

    interface InnerInterface {
        void interfaceMehtod();
    }

    class InnerInterfaceImpl1 implements InnerInterface {

        @Override
        public void interfaceMehtod() {

        }
    }

}
