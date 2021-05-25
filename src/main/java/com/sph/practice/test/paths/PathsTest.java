package com.sph.practice.test.paths;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 路径相关
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
public class PathsTest {

    /**
     * URI：一个URL地址全路径
     */
    @Test
    public void test1() throws URISyntaxException {
        URI uri = new URI("http://localhost:8085/shop/ok");
        System.out.println(uri.getScheme());
    }

    /**
     * Path类：路径类，与URI类类似，（URI的的构造方法就是你传进来一个String的全路径，然后它会去对这个地址进行切割，切割完后，放到自己定义的成员变量当中）
     */
    @Test
    public void test2() throws IOException {
        String first = "security";
        String format = "yyyy-MM-dd";
        // 当前日期字符串
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(format));
        // 目录路径类，可以用来拼接目录路径
        Path path = Paths.get(first, date, "temp");
        System.out.println(path.toString());
        /*
            security\2021-05-21\temp
         */
    }



}
