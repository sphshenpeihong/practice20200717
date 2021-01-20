package com.sph.practice.mybatis.vo;

import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.pojo.QyStudentPO;

import java.util.List;

/**
 * Created by Shen Peihong on 2021/1/20
 * Description:
 *
 * @since 1.0.0
 */
public class CSVO1 extends QyClassPO {

    //学生列表
    private QyStudentPO studentPO;

    public QyStudentPO getStudentPO() {
        return studentPO;
    }

    public void setStudentPO(QyStudentPO studentPO) {
        this.studentPO = studentPO;
    }
}
