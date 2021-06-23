package com.sph.practice.test.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Data
public class MqttDTO implements Serializable {
    private Integer count;
    private String username;
    private String password;
    private Integer sex;
}
