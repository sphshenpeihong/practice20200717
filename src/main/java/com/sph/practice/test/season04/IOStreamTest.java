package com.sph.practice.test.season04;

import com.google.common.collect.Lists;
import com.google.common.primitives.Bytes;
import com.sph.practice.test.bean.UserParam;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/9/17 22:55
 * Description: Java虚拟机与硬盘之间的数据传输 基于IO流
 *
 * @since 1.0.0
 */
public class IOStreamTest {
    /**
     * 操作字节流 File指向一个文件，若我们程序里面向获取这个文件的内容的话，需要转换成字节流，然后使用字节流提供的read()方法才可以读取，读取完得到的是一个 字节数组类型
     * 得到了字节数组类型，我们可以利用new String(type[] t) 提供了构造方法，进而转成了String类型
     * 涉及到IO流对象 到时候用完finally都要关闭
     */
    @Test
    public void test(){

    }

}
