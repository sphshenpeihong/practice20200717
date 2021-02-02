package com.sph.practice.test.bean;

import com.sph.practice.test.param.BankVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;
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

    /**
     *
     */
    @Test
    public void test1(){
        //startWith
        String str = "666";
        boolean b = "6".startsWith(str);
        System.out.println(b);
        // 当前管理的部门 123
        //  用户绑定的部门是12
        // 用户绑定的是中交->灏明
        // 管理员管理的部门是 中交->灏明->666
        // userBindDeptFullName.startsWith(manageDeptFullName)
        String userBindDeptFullName = "中交集团->1郝明测试";
        String manageDeptFullName = "中交集团->1郝明测试->65464";
        boolean b1 = userBindDeptFullName.startsWith(manageDeptFullName);
    }

  /*  public BankVO getBankVO() {
        return bankVO;
    }

    public void setBankVO(BankVO bankVO) {
        this.bankVO = bankVO;
    }*/
}
