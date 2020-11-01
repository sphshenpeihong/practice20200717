package com.sph.practice.test.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Shen Peihong on 2020/10/28 20:00
 * Description:
 *
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class POIVO implements Serializable,Cloneable {
    //id
    private String id;
    //标题
    private String title;
    //账号
    private String username;
    //密码
    private String password;



}
