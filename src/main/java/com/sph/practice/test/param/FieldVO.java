package com.sph.practice.test.param;

import lombok.ToString;

/**
 * Created by Shen Peihong on 2020/12/26 16:35
 * Description:
 *
 * @since 1.0.0
 */
@ToString
public class FieldVO {
    private Integer id;
    private String username;
    private int score;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
