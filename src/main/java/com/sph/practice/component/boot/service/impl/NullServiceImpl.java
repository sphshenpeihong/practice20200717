package com.sph.practice.component.boot.service.impl;

import com.sph.practice.component.boot.service.NullService;
import org.springframework.stereotype.Service;

/**
 * @author sphong
 * @version: 1.0
 * @date 2021/4/15
 * @since V1.0.0.2
 */
@Service("nullService")
public class NullServiceImpl implements NullService {
    @Override
    public String null1(String str, Object o) {
        return "hello";
    }
}
