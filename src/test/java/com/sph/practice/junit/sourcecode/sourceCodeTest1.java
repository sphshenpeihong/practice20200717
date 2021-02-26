package com.sph.practice.junit.sourcecode;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Shen Peihong on 2021/2/26
 * Description:
 *
 * @since 1.0.0
 */
@SpringBootTest
public class sourceCodeTest1 {

    /**
     *
     */
    @Test
    public void test1() throws IOException {
        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("BOOT-INF/classes/banner.txt");
        URL url = resources.nextElement();
        UrlResource resource = new UrlResource(url);
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        System.out.println(properties);
    }

}
