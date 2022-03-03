package com.sph.practice.component.boot.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Order(3)
public @interface ActionRoles {
    String[] value();
}
