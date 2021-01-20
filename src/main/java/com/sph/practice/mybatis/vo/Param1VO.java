package com.sph.practice.mybatis.vo;

import lombok.ToString;

/**
 * Created by Shen Peihong on 2021/1/19
 * Description: 测测dao层用别名是否可以成功映射
 *
 * @since 1.0.0
 */
@ToString
public class Param1VO {

    private Integer id;

    private String userNamea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNamea() {
        return userNamea;
    }

    public void setUserNamea(String userNamea) {
        this.userNamea = userNamea;
    }
}
