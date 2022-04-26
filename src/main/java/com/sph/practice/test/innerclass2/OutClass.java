package com.sph.practice.test.innerclass2;

import lombok.Data;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class OutClass {

    private Integer code;
    private String message;
    private InnerClass innerClass;

    public static class StaticInnerClass {}

    @Data
    public class InnerClass {
        private Integer id;
        private String username;
        private String password;
    }

}
