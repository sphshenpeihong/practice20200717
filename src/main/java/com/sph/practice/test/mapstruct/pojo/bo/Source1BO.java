package com.sph.practice.test.mapstruct.pojo.bo;

import com.sph.practice.test.mapstruct.pojo.dto.MapStructSonDTO;
import lombok.Data;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@Data
public class Source1BO {

    private Integer id;

    private MapStructSonBO son;
    // private String son;
}
