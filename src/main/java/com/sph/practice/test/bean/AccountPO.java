package com.sph.practice.test.bean;

/**
 * Created by Shen Peihong on 2020/9/8 14:55
 * Description:
 *
 * @since 1.0.0
 */
public class AccountPO {

    private Integer id;
    private String username;
    private String password;
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public AccountPO(){}

    public AccountPO(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
