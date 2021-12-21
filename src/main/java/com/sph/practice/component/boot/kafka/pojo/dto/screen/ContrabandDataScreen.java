package com.sph.practice.component.boot.kafka.pojo.dto.screen;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class ContrabandDataScreen {

    private String relationId;

    private Long handleTime = System.currentTimeMillis();

    private List<String> imgUrl = Lists.newArrayList();

    private String handleType = "1";

    private String handleEmpName = "刘芳";

    private String handleEmpType = "2";


}
