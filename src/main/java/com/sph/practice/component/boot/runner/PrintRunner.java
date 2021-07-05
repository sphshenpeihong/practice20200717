package com.sph.practice.component.boot.runner;

import com.sph.practice.component.boot.config.SpringBootConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 打印你好，中国！
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Component
public class PrintRunner implements CommandLineRunner {

    @Resource
    private SpringBootConfig config;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("你好，中国！");
    }
}
