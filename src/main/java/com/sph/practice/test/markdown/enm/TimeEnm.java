package com.sph.practice.test.markdown.enm;

/**
 * Created by Shen Peihong on 2020/10/21 20:09
 * Description:
 * 尝试在枚举中定义静态变量、方法，是否外部可以访问到？
 *
 * @since 1.0.0
 */
public enum TimeEnm {
    Time1("2020-10-21"),
    Time2("201+9")
    ;

    static String str = "test";

    //定义枚举成员变量
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    TimeEnm(String time) {
        this.time = time;
    }
}
