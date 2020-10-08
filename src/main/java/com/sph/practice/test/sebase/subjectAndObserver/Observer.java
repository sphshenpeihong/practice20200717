package com.sph.practice.test.sebase.subjectAndObserver;

import java.util.List;

/**
 * Created by Shen Peihong on 2020/10/8 20:49
 * Description:
 *
 * @since 1.0.0
 */
public interface Observer {

    //接收通知
    public void receipt(List<String> receiptList);

}
