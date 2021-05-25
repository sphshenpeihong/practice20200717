package com.sph.practice.test.mapstruct.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapStructDTO {

    private int id;

    private String username;

    private String password;

    private MapStructSonDTO son;

    private List<MapStructSonDTO> sons;



}
