package com.sph.practice.test.controller.extend;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shen Peihong on 2020/11/22 11:35
 * Description:
 *
 * @since 1.0.0
 */
public abstract class TypeCtl {
    //定义两个变量
    //funcCode：区分模块
    //Class 子类的class反射对象,因为到时候可能需要获取数据库的PO值，需要指定一个返回值啥的
    protected String funcCode;
    protected Class clazz;

    public abstract void setFuncCode();
    public abstract void setClazz();

    private void init(){
        if (StringUtils.isEmpty(this.funcCode)){
            this.setFuncCode();
        }
        if (this.clazz == null){
            this.setClazz();
        }
    }

    //分类判断
    @RequestMapping("/judgeCatecory.do")
    public void judgeCatecory(){
        System.out.println("父：" + this.getClass());
        init();
        if ("subject".equals(this.funcCode)){
            System.out.println("当前是课程分类，打印分类的Class对象：" + this.clazz);
        }else if ("live".equals(this.funcCode)){
            System.out.println("当前是直播分类，打印分类的Class对象：" + this.clazz);
        }
    }
}
