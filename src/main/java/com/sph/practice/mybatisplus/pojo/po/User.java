package com.sph.practice.mybatisplus.pojo.po;

import lombok.Data;


/**
 * Created by Shen Peihong on 2021/1/26
 * Description:
 *
 * @since 1.0.0
 */

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

