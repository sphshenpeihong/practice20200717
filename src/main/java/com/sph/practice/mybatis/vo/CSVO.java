package com.sph.practice.mybatis.vo;

import lombok.*;

/**
 * Created by Shen Peihong on 2020/12/13 2:59
 * Description:
 *
 * @since 1.0.0
 */
public class CSVO {
    private Integer classId;
    private String className;
    private Integer studentId;
    private String studentName;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "CSVO{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
