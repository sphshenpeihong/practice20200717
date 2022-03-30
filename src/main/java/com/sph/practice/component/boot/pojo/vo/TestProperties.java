package com.sph.practice.component.boot.pojo.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Component
@ConfigurationProperties(prefix = "cxaxasr-lasxist")
@Data
public class TestProperties {

    private String carName;

}
