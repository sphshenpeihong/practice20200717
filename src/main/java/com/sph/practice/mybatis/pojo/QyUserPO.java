package com.sph.practice.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@TableName("qy_user")
public class QyUserPO implements Cloneable, Serializable {

    private Integer id;
    private String userName;
    private String password;

}
