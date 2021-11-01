package com.sph.practice.test.controller.test;

import com.google.common.collect.Lists;
import com.sph.practice.test.controller.test.vo.SubTest1VO;
import com.sph.practice.test.controller.test.vo.Test1VO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@RestController
@RequestMapping("/simulationTest")
public class SimulationTestController {

    @RequestMapping("/test1")
    public Object test1() {

        SubTest1VO subTest1VO = new SubTest1VO();
        subTest1VO.setTotal(2);
        subTest1VO.setDeviceId("AAA");
        subTest1VO.setEventIdList(Lists.newArrayList(1L, 2L, 3L));

        SubTest1VO subTest1VO1 = new SubTest1VO();
        subTest1VO1.setTotal(3);
        subTest1VO1.setDeviceId("BBB");
        subTest1VO1.setEventIdList(Lists.newArrayList(1L, 2L, 3L));


        Test1VO test1VO = new Test1VO();
        test1VO.setAllTotal(5);
        test1VO.setList(Lists.newArrayList(subTest1VO, subTest1VO1));

        return test1VO;

    }

}
