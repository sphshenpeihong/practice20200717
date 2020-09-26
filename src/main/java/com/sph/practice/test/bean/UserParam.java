package com.sph.practice.test.bean;

import java.io.Serializable;

/**
 * Created by Shen Peihong on 2020/8/27 16:45
 * Description:实现克隆、序列化接口，声明该类可以被克隆，以及支持被序列化与反序列化 若类在进行网络传输或缓存存储时，故需要进行序列化操作 序列化成IO流或json对象或XML对象
 * 序列化的过程中需要一个序列化版本UID 若不写，默认是1L
 * IO流就类似一个包裹，我们可以对包裹进行读写操作，运输的时候，是这个包裹在进行运输
 *
 * @since 1.0.0
 */
public class UserParam implements Cloneable, Serializable {
    private static final Long serialVersionUID = 1L; //若PO、VO等类实现了序列化接口
    private String id;
    private String usernmae;
    private String password;
    private String sex;
    private transient String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 在本类中直接使用clone方法，是先用Object祖先类去调用方法，返回的实例再去向下强转
     * @return
     */
    public UserParam clone(){
        try {
            return (UserParam) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public UserParam(){

    }

    public UserParam(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
