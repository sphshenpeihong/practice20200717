package com.sph.practice.test.inner2;

import lombok.Data;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Data
public class OuterClass {

    OuterClass() {}

    // 外部类对象无法访问到内部类的信息，所以封装完内部类对象后，需要将对象给带出来给外部类
    OuterClass(OuterClass.InnerClass innerClass) {

    }

    private String username;
    private String password;

    class InnerClass {
        private String iUsername;
        private String iPassword;

        void test() {

        }

        // 修改成员变量iUsername
        public InnerClass setiUsername(String iUsername) {
            this.iUsername = iUsername;
            return this;
        }

        // 修改成员变量iPassword
        public InnerClass setiPassword(String iPassword) {
            this.iPassword = iPassword;
            return this;
        }

        // 返回外部类对象（将当前对象待到外部类的构造方法形参中）
        public OuterClass build() {
            return new OuterClass(this);
        }
    }

    static class SInnerClass {
        private String siUsername;
        private String siPassword;
    }

    interface InnerInterface {

    }


}
