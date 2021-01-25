package com.sph.practice.mybatis.vo;

import com.sph.practice.mybatis.pojo.QyStudentPO;

import java.util.List;

/**
 * Created by Shen Peihong on 2021/1/23
 * Description: 一对多试试
 *
 * @since 1.0.0
 */
public class ClassVO {
    private Integer id;
    private String className;
    private List<QyStudentPO> studentPOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<QyStudentPO> getStudentPOList() {
        return studentPOList;
    }

    public void setStudentPOList(List<QyStudentPO> studentPOList) {
        this.studentPOList = studentPOList;
    }

    @Override
    public String toString() {
        return "ClassVO{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", studentPOList=" + studentPOList +
                '}';
    }
}
