package com.sph.practice.test.anjian.authentication;

import lombok.Data;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class CARoleDataDTO {

    // 角色名称
    private String roleName;

    // 角色描述
    private String description;

    // 应用数据
    private List<CAAppDataDTO> permissionList;

}
