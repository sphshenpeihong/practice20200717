package com.sph.practice.test.controller.bean;

import lombok.*;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * Created by Shen Peihong on 2021/1/3 15:45
 * Description:
 *
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParamBean implements Serializable {

    @NotBlank(message = "参数不能为空")
    private String id;

    private String username;

    private String password;

}
