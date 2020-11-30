package com.sph.practice.test.markdown.designPattern.composite;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/11/28 19:53
 * Description:
 *
 * @since 1.0.0
 */
public class University extends Component {

    List<Component> componentList = new ArrayList<>();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }

    @Override
    public void print() {
        System.out.println("打印");
        System.out.println(componentList);
    }
}
