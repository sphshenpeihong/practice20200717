package com.sph.practice.test.markdown.annotationAndReflect;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Shen Peihong on 2020/11/15 23:19
 * Description:用户实体类
 *
 * @since 1.0.0
 */
@Setter
@Getter
public class UserPO {
    @JSONField
    private String id;
    @MyAnnotation(seldDefine = "123123")
    private String username;
    private String password;

    public UserPO(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    private UserPO(String id) {
        this.id = id;
    }

    public UserPO(){

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

    private void test(){}

    @Override
    public String toString() {
        return "UserPO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
