package com.sph.practice.test.annotation;

import lombok.ToString;

/**
 * Created by Shen Peihong on 2021/1/30
 * Description:
 *
 * @since 1.0.0
 */
@ToString
public class UseBean {

    private Integer id;

    // 使用咱们自定义的注解
    @AnnotationBean
    private String username;

    private String password;

}
