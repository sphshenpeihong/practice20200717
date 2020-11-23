package com.sph.practice.test.controller.extend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/11/22 11:36
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mgr/subject")
public class SubjectMgrCtl extends TypeCtl {

    @Override
    public void setFuncCode() {
        super.funcCode = "subject";
    }

    @Override
    public void setClazz() {
        super.clazz = this.getClass();
        System.out.println("沈培泓打印一下当前的class对象：" + this.getClass());
    }

    @RequestMapping("test1.do")
    public void test1(){

    }


}
