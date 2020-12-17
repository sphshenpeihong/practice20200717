package com.sph.practice.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Shen Peihong on 2020/12/13 2:59
 * Description:
 *
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CSVO {
    private Integer classId;
    private String className;
    private Integer studentId;
    private String studentName;
}
