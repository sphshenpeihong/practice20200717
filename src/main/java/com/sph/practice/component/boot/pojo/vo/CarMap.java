package com.sph.practice.component.boot.pojo.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Shen Peihong on 2021/2/23
 * Description:
 *
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "car-map")
@Data
public class CarMap {

    private Map<String, Car> carMap;

}
