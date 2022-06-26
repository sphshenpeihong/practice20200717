package com.sph.practice.component.boot.pojo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Getter
@AllArgsConstructor
public enum HelloEnum {

    TEST(1, "哈哈哈哈"),
    ;
    private Integer username;
    private String password;
}
