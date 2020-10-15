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
@Api("银行信息VO")
@ApiModel("银行信息实体类")
public class BankVO {

    @ApiModelProperty("卡号id")
    private String id;
    @ApiModelProperty("卡号号码")
    private String cardNumber;
    private String personName;

}
