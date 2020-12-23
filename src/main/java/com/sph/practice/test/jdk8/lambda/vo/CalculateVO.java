package com.sph.practice.test.jdk8.lambda.vo;

import lombok.*;

/**
 * Created by Shen Peihong on 2020/12/23 14:51
 * Description:
 *
 * @since 1.0.0
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CalculateVO {
    private Integer id;
    private Integer num;
    private Integer parentId;
}
