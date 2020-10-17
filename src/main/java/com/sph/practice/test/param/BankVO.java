package com.sph.practice.test.param;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Shen Peihong on 2020/10/13 16:49
 * Description:
 *
 * @since 1.0.0
 */
@Data
@Api(tags = {"银行信息V6O"}) //表示说明实体类
@ApiModel("银行信息实体类")
public class BankVO {

    @ApiModelProperty("卡号id")
    private String id;
    @ApiModelProperty("卡号号码")
    private String cardNumber;
    private String personName;

}
