package com.sph.practice.test.param;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Shen Peihong on 2020/10/16 16:43
 * Description:学生VO
 *
 * @since 1.0.0
 */
@Data
@Api(tags = {"学生信息VO"})
@ApiModel(
        value = "学生信息VO", description = "用于描述学生的各个信息"
)
public class StudentVO {

    @ApiModelProperty(value = "学生id", example = "5wqe1qw2e11w2e1w", required = true, dataType = "String", name = "id", allowEmptyValue = false)
    private String id;

    @ApiModelProperty(value = "学生姓名", example = "张飞", required = true, dataType = "String", name = "name", allowEmptyValue = false)
    private String name;

    @ApiModelProperty(value = "学生年龄", example = "16", required = true, dataType = "String", name = "age", allowEmptyValue = false)
    private String age;



}
