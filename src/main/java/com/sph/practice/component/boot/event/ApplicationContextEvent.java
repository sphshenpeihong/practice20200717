package com.sph.practice.component.boot.event;

import com.sph.practice.mybatis.util.ApplicationContextUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文对象事件通知
 *
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/11
 */
@Component
public class ApplicationContextEvent implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.setContext(applicationContext);
    }
}
