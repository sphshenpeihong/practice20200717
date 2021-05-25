package com.sph.practice.test.controller.ui.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Shen Peihong on 2021/2/25
 * Description:
 *
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"password", "sex"})
public class CacheVO implements Serializable {

    private Integer id;
    private String username;

}
