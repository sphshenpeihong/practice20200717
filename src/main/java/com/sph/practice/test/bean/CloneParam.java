package com.sph.practice.test.bean;

/**
 * Created by Shen Peihong on 2020/9/24 20:58
 * Description:
 *
 * @since 1.0.0
 */
public class CloneParam implements Cloneable {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //返回当前类的克隆对象 ,方法声明成静态的话，那么里面的成员变量需要使用静态变量，不能使用成员变量，因为成员变量的存储位置是存放在堆里面
    public CloneParam clone(){
        try {
            ReflectUser.test1();
            CloneParam cloneParam = (CloneParam) super.clone();
            return cloneParam;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
