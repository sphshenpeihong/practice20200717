package com.sph.practice.mybatisplus.pojo.enm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@AllArgsConstructor
@Getter
public enum BaseEnum {
    TIME_IS_NOT_NULL(0, "传入时间不能为空"),
    ;

    private final Integer code;
    private final String desc;
}
