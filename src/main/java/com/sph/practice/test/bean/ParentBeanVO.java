package com.sph.practice.test.bean;

import com.sph.practice.test.param.BankVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Shen Peihong on 2020/12/19 22:45
 * Description:
 *
 * @since 1.0.0
 */
//@Component
public class ParentBeanVO {
    private String parentStr = "123";
    private static BankVO bankVO;

    static {
        System.out.println("看谁先执行");
        bankVO = new BankVO("1","2","3");
    }

    public String getParentStr() {
        return parentStr;
    }

    public void setParentStr(String parentStr) {
        this.parentStr = parentStr;
    }

  /*  public BankVO getBankVO() {
        return bankVO;
    }

    public void setBankVO(BankVO bankVO) {
        this.bankVO = bankVO;
    }*/
}
