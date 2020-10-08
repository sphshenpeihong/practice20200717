package com.sph.practice.test.sebase.subjectAndObserver;

import java.util.List;

/**
 * Created by Shen Peihong on 2020/10/8 20:49
 * Description: 主题类提供离职指定人方法(方法形参是离职人的userId的list列表)，方法实现是对指定的人员进行离职操作处理
 * 提供方法2：下发通知方法，需要去给指定的观察者下发通知，不想给所有的观察者都下发通知，只给指定需要的观察者下发通知，故需要定义一个list大全
 * 算了，先直接给实现了Observer接口的全部实例，都调用它们的接收通知方法
 *
 * @since 1.0.0
 */
public interface Subject {

    //离职指定的相关人员
    public void dimission(List<String> dismissionList);

    //通知
    public void inform(List<String> dismissionList);

}
