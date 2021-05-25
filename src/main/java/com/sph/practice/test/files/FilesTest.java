package com.sph.practice.test.files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Files工具类，针对File进行封装
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
public class FilesTest {

    /**
     * Files
     */
    @Test
    public void test1() throws IOException {
        Path path = getPath();
        //Paths.get("security", )
    }

    /**
     * Path类：路径类，与URI类类似，（URI的的构造方法就是你传进来一个String的全路径，然后它会去对这个地址进行切割，切割完后，放到自己定义的成员变量当中）
     */
    public static Path getPath() throws IOException {
        String first = "security";
        String format = "yyyy-MM-dd";
        // 当前日期字符串
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(format));
        // 目录路径类，可以用来拼接目录路径
        Path path = Paths.get(first, date, "temp");
        return path;
    }

}
