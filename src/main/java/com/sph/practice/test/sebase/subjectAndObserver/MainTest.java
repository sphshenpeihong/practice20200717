package com.sph.practice.test.sebase.subjectAndObserver;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/10/8 21:06
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/inform")
public class MainTest {

    @RequestMapping("/test1.do")
    public void test1(){
        //对张三和李四进行离职操作
        Subject subject = new SubjectObject();
        subject.dimission(Lists.newArrayList("zhangsan", "lisi"));
    }

}
