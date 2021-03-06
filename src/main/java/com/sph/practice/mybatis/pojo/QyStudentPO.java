package com.sph.practice.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Shen Peihong on 2020/12/13 2:56
 * Description:
 *
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QyStudentPO {
    private Integer id;
    private String studentName;
    private Integer classId;
}
