package com.sph.practice.test.param;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Shen Peihong on 2020/10/13 17:00
 * Description:
 *
 * @since 1.0.0
 */
public class TeacherVO implements Cloneable, Serializable {
    @JSONField(name = "id1")
    private String id;
    private String teacherName;
    private String teacherAge;
    @JSONField(format = "yyyyMMdd")
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TeacherVO{" +
                "id='" + id + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAge='" + teacherAge + '\'' +
                ", time=" + time +
                '}';
    }
}
