package com.sph.practice.test.genericity;

import lombok.Data;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class Bank<T> {

    private T object;

}
