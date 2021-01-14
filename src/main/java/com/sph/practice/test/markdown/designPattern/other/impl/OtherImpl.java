package com.sph.practice.test.markdown.designPattern.other.impl;

import com.sph.practice.test.markdown.designPattern.other.IOther;

/**
 * Created by Shen Peihong on 2021/1/12
 * Description: 抽象类实现接口，不需要去重写接口所定义的方法
 * 虽然抽象类不需要去重写实现接口里面的方法，但是一旦子类继承该抽象类的时候，如果说父类都没去实现定义的接口的话，那么子类就需要去重写了。
 * 我们可能定义了一个类，打算去实现某个接口里面多定义的诸多接口（可能定义了10个接口，但我们只想实现5个接口，就足够使用了），但是如果直接定义了一个类，直接就去实现接口的话，
 * 那么必定是需要实现接口定义的10个接口，但如果我们中间设置了一层类，这个类去实现完接口后，写空实现就行了，
 *
 * @since 1.0.0
 */
public abstract class OtherImpl implements IOther {

    public void otherTest(){}

}
