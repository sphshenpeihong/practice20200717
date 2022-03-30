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
public class ContrabandDataGoods {

    private Long goodId;

    private String goodName = "12";

    private String goodHandleType = "1";

    private String remark = "1";

    private Integer number = 1;

    private String goodType = "1";

    private List<String> goodPhotos = Lists.newArrayList("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");

}