package com.sph.practice.test.controller.extend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/11/22 12:11
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mgr/live")
public class LiveMgrctl extends TypeCtl {
    @Override
    public void setFuncCode() {
        super.funcCode = "live";
    }

    @Override
    public void setClazz() {
        super.clazz = this.getClass();
        System.out.println("沈培泓打印一下当前的class对象：" + this.getClass());
    }
}
