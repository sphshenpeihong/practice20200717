package com.sph.practice.test.singleton.test;

/**
 * Created by Shen Peihong on 2020/10/18 1:56
 * Description:
 *
 * @since 1.0.0
 */
public class SingletonUser {
    private static Integer id;

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        SingletonUser.id = id;
    }
}
