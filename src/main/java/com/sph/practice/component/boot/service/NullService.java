package com.sph.practice.component.boot.service;


import lombok.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author sphong
 * @version: 1.0
 * @date 2021/4/15
 * @since V1.0.0.2
 */
public interface NullService {

    String null1(@Nullable String str, Object o);

}
