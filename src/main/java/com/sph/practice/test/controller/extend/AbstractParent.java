package com.sph.practice.test.controller.extend;

/**
 * Created by Shen Peihong on 2020/11/22 12:23
 * Description:
 *
 * @since 1.0.0
 */
public abstract class AbstractParent {

    void init(){
        //抽象父类的this,永远是输出子类的class对象的，因为父类没办法自己调用自己的方法
        System.out.println(this.getClass());
    }

}
