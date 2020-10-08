package com.sph.practice.test.sebase.subjectAndObserver;

import java.util.List;

/**
 * Created by Shen Peihong on 2020/10/8 20:49
 * Description:
 *
 * @since 1.0.0
 */
public class ObserverObject implements Observer {
    @Override
    public void receipt(List<String> receiptList) {
        //对相关人员进行操作
        for (String receipt : receiptList) {
            System.out.println("去除：" + receipt + " 数据成功");
        }
    }
}
