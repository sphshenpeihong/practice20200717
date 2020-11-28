package com.sph.practice.test.markdown.designPattern.adapter;

/**
 * Created by Shen Peihong on 2020/11/27 1:21
 * Description:适配器类
 *
 * @since 1.0.0
 */
public class U5V implements IU5V {

    //对象适配器，以聚合的方式
    private U220V u220V;

    public U5V(U220V u220V) {
        this.u220V = u220V;
    }

    @Override
    public Integer Translate220VTo5V() {
        Integer result = 0;
        if (u220V != null){
            Integer u = u220V.u220V();
            result = u / 44;
        }
        return result;
    }
}
