package com.sph.practice.test.serialization.dto.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Data
public class People implements Serializable {
    private String name;
    private int age;
    private Friend friend;
    private int[] stature;
}
