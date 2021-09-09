package com.sph.practice.test.sebase.cycle;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Service("cycleService2")
public class CycleService2 {

    @Resource
    private CycleService1 cycleService1;

}
