package com.sph.practice.mybatisplus.pojo.po;

import lombok.Data;


/**
 * Created by Shen Peihong on 2021/1/26
 * Description:
 *
 * @since 1.0.0
 */

@Data
public class QyPlusUserPO {

    // MP提供了很多主键生成策略，只需要你在实体类的id上面加个注解制订后

    private Long id;
    private String name;
    private Integer age;
    private String email;
}

