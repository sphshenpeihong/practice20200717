package com.sph.practice.test.spring.utils;

import com.sph.practice.test.bean.AccountPO;
import com.sph.practice.test.bean.AccountVO;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Created by Shen Peihong on 2020/9/8 14:52
 * Description: VO与PO的属性映射 使用Spring-web的工具类 BeanUtils.copyProperties();
 *
 * @since 1.0.0
 */
public class JavaBeanConvert {

    /**
     * 自定义PO和VO，然后使用BeanUtils.copyProperties(po,vo);进行自动映射
     */
    @Test
    public void test(){
        AccountVO accountVO = new AccountVO("1","zhangsan","123456","boy");
        AccountPO accountPO = new AccountPO();
        System.out.println("打印1");
        BeanUtils.copyProperties(accountVO, accountPO);
        accountPO.setId(Integer.valueOf(accountVO.getId()));
        System.out.println("打印2");
    }

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class c1 = AccountPO.class;
        AccountPO o = (AccountPO)c1.newInstance();
    }

}
