package com.sph.practice.test.controller.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Shen Peihong on 2021/4/6
 * Description:
 *
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidDTO {

    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull
    private String username;

    /*@NotEmpty(message = "list不能为空额")
    private List<String> list;*/

    private List<DefaultBean> listRef;

}
