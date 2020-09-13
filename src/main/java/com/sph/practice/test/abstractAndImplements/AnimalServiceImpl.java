package com.sph.practice.test.abstractAndImplements;

/**
 * Created by Shen Peihong on 2020/9/13 16:30
 * Description:
 *
 * @since 1.0.0
 */
public class AnimalServiceImpl implements AnimalService {
    @Override
    public String say() {
        this.print();
        return "say汪汪叫";
    }

    private void print(){
        System.out.println("print111");
    }
}
