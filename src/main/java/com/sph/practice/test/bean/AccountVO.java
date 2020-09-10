package com.sph.practice.test.bean;

/**
 * Created by Shen Peihong on 2020/9/8 14:55
 * Description:
 *
 * @since 1.0.0
 */
public class AccountVO {

    private String id;
    private String username;
    private String password;
    private String sex;

    public AccountVO() {}

    public AccountVO(String id, String username, String password, String sex) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
