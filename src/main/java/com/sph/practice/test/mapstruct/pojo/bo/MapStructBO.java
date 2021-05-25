package com.sph.practice.test.mapstruct.pojo.bo;

import com.sph.practice.test.mapstruct.pojo.dto.MapStructSonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapStructBO {
    private Integer id;

    private String username;

    private String password;

    private MapStructSonBO son;

    private List<MapStructSonBO> sons;

}
