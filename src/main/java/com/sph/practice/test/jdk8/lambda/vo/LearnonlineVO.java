package com.sph.practice.test.jdk8.lambda.vo;

import lombok.*;

/**
 * Created by Shen Peihong on 2020/12/23 15:23
 * Description:考试、试卷、题目杂乱的VO类，包含这三者的id以及相关信息
 *
 * @since 1.0.0
 */
public class LearnonlineVO {
    private Integer id;
    private String examId;
    private String examName;
    private String testpaperId;
    private String testpaperName;
    private String sectionId;
    private String sectionName;


    @Override
    public String toString() {
        return "LearnonlineVO{" +
                "id=" + id +
                ", examId='" + examId + '\'' +
                ", examName='" + examName + '\'' +
                ", testpaperId='" + testpaperId + '\'' +
                ", testpaperName='" + testpaperName + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }

    public LearnonlineVO(){}

    public LearnonlineVO(Integer id, String examId, String examName, String testpaperId, String testpaperName, String sectionId, String sectionName) {
        this.id = id;
        this.examId = examId;
        this.examName = examName;
        this.testpaperId = testpaperId;
        this.testpaperName = testpaperName;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getTestpaperId() {
        return testpaperId;
    }

    public void setTestpaperId(String testpaperId) {
        this.testpaperId = testpaperId;
    }

    public String getTestpaperName() {
        return testpaperName;
    }

    public void setTestpaperName(String testpaperName) {
        this.testpaperName = testpaperName;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
