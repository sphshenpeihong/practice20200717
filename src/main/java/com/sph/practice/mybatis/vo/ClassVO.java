package com.sph.practice.mybatis.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sph.practice.mybatis.pojo.QyStudentPO;
import lombok.Data;

import java.util.List;

/**
 * Created by Shen Peihong on 2021/1/23
 * Description: 一对多试试
 *
 * @since 1.0.0
 */
@Data
public class ClassVO {
    //@JSONField(name = "Id")
    @JsonProperty(value = "Id")
    private Integer id;
    private String className;
    @JSONField
    private List<QyStudentPO> studentPOList;
    // 基本变量
    //

}
