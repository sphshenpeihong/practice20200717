package com.sph.practice.test.sebase.subjectAndObserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/10/8 20:50
 * Description:
 *
 * @since 1.0.0
 */
@Component
public class SubjectObject implements Subject {


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void dimission(List<String> dismissionList) {
        //进行离职操作
        for (String dismission : dismissionList) {
            System.out.println("删除人员：" + dismission + " 成功");
        }
        this.inform(dismissionList);
    }

    @Override
    public void inform(List<String> dismissionList) {
        Map<String, Observer> observerMap = applicationContext.getBeansOfType(Observer.class);
        for (Map.Entry<String, Observer> entry : observerMap.entrySet()) {
            System.out.println("当前被通知的实例对象为：" + entry.getKey());
            //执行通知操作
            entry.getValue().receipt(dismissionList);
        }
    }
}
