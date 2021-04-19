package com.sph.practice.test.controller.request;

import lombok.Data;

import java.util.List;

/**
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/4/18
 */
@Data
public class Receive2DTO {

    private String id;

    private ObjectVO objectVO;

    private List<ArrayVO> arrayVOList;

}
