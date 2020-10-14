package com.sph.practice.test.bean;

import com.sph.practice.test.abstractAndImplements.IEnumService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/9/24 22:04
 * Description:
 *
 * @since 1.0.0
 */
public enum TimeEnm implements IEnumService {
    //定义已被实例化的对象，没有括号传参代表是代表当前枚举类的无参构造方法实例化的
    TIME1("2020-09-24"),
    TIME2("2020-09-25"),
    TIME3,
    ;
    //定义枚举成员变量
    private String time;
    public static Map<String, Object> paramMap = new HashMap<String, Object>();

    TimeEnm(String time) {
        this.time = time;
    }

    TimeEnm(){}


    public String getTime() {
        time = time + paramMap.get("username");
        return "当前时间为：" + time + this.end();
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String end(){
        return " 结束。";
    }

    //初始化方法，初始化本地缓存map
    private static void init(){
        paramMap.put("username", "123");
        paramMap.put("password", "456");
    }

    //定义本地缓存map
    static {
        init();
    }

    //提供当前实例化枚举对象调用
    public String getTest1(){
        return "getTest1";
    }
}
