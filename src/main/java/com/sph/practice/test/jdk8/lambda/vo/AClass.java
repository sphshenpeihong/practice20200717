package com.sph.practice.test.jdk8.lambda.vo;

import lombok.*;

/**
 * Created by Shen Peihong on 2020/12/22 21:26
 * Description:
 *
 * @since 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AClass {
    private Integer id;
    private String username;
    private String password;

    /*public Integer getId() {
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
    }*/
}
