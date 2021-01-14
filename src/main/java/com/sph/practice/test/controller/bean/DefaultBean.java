package com.sph.practice.test.controller.bean;

import lombok.ToString;

/**
 * Created by Shen Peihong on 2021/1/6
 * Description:
 *
 * @since 1.0.0
 */
@ToString
public class DefaultBean {

    private boolean flag;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
