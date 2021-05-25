package com.sph.practice.component.boot.pojo.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@Data
@Component
@ConfigurationProperties("mapperpath")
public class MapperPath {

    private String testYiXiaa;

}
