package com.sph.practice.component.spring.aopannotation;

import org.aspectj.lang.annotation.*;

/**
 * Created by Shen Peihong on 2021/3/2
 * Description:
 *
 * @since 1.0.0
 */
@Aspect
public class LogAcspect {

    // 指向切入点
    @Pointcut("execution(public void com.sph.practice.component.spring.aopannotation.MathCulculate.*(..))")
    private void pointCut() {

    }

    // 前置通知
    @Before("pointCut()")
    public void before() {
        System.out.println("before");
    }

    // 后置通知
    @After("pointCut()")
    public void after() {
        System.out.println("after");
    }

    // 成功执行完方法后，通知
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    // 有异常时 通知
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    // 环绕通知
    @Around("pointCut()")
    public void around() {
        System.out.println("around");
    }


}
