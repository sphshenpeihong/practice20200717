package com.sph.practice.test.jdk8.lambda.vo;

import lombok.*;

import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/22 21:26
 * Description:
 *
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ListContainer {
    private List<AClass> lst;
}
