package com.sph.practice.mybatis.vo;

import com.sph.practice.mybatis.pojo.QyClassPO;

/**
 * Created by Shen Peihong on 2021/1/23
 * Description: 先试试多对一，对于学生来说就是多，对于班级来说就是一
 *
 * @since 1.0.0
 */
public class StudentVO {
    private Integer id;
    private String studentName;
    private Integer classId;
    private QyClassPO classPO;

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", classId=" + classId +
                ", classPO=" + classPO +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public QyClassPO getClassPO() {
        return classPO;
    }

    public void setClassPO(QyClassPO classPO) {
        this.classPO = classPO;
    }
}
