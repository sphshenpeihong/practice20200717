package com.sph.practice.test.sebase.cycle;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Service("cycleService1")
public class CycleService1 {

    @Resource
    private CycleService2 cycleService2;

}
