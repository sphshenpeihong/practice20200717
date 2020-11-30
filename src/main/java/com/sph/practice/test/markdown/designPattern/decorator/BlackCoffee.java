package com.sph.practice.test.markdown.designPattern.decorator;

/**
 * Created by Shen Peihong on 2020/11/28 15:05
 * Description:
 *
 * @since 1.0.0
 */
public class BlackCoffee extends Coffee {

    //由于到时候人们去购买咖啡的话，只会去购买具体的咖啡，而不会说直接买咖啡，所以会new具体定义品种的咖啡类
    //既然一定要new的话，那么一定会利用到构造方法呢，所以我们这里可以把set成员变量的时机就放在构造方法里面呢
    public BlackCoffee(){
        super.setPrice(5f);
        super.setDesc("黑咖啡");
    }

}
