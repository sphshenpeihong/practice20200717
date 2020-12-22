package com.sph.practice.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Shen Peihong on 2020/12/19 20:18
 * Description:
 *
 * @since 1.0.0
 */
@Data
@ToString
@AllArgsConstructor
public class QyUserPO implements Cloneable, Serializable {

    private String id;
    private String userName;

}
