package com.sph.practice.test.param;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Shen Peihong on 2020/10/13 16:49
 * Description:
 *
 * @since 1.0.0
 */
@Api(tags = {"银行信息V6O"}) //表示说明实体类
@ApiModel("银行信息实体类")
public class BankVO implements Serializable {

    @ApiModelProperty("卡号id")
    private String id;
    @ApiModelProperty("卡号号码")
    private String cardNumber;
    private String personName;

    public BankVO(){}

    public BankVO(String id, String cardNumber, String personName) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.personName = personName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "BankVO{" +
                "id='" + id + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", personName='" + personName + '\'' +
                '}';
    }
}
