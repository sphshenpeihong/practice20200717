package com.sph.practice.test.bean;

import java.io.Serializable;

/**
 * Created by Shen Peihong on 2020/5/21 10:38
 * Description:
 *
 * @since 1.0.0
 */
public class User1 implements Cloneable, Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer parentId;
    private Integer score;


    //提供克隆方法
    public User1 clone(){
        try {
            return (User1) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public User1(Integer id, String username, String password, Integer parentId, Integer score) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.parentId = parentId;
        this.score = score;
    }

    public User1(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User1(Integer id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User1(Integer id, String username, String password, Integer parentId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.parentId = parentId;
    }

    public User1() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", parentId=" + parentId +
                ", score=" + score +
                '}';
    }
}
