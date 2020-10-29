package com.sph.practice.test.sebase;

import com.sph.practice.test.bean.UserParam;
import org.junit.Test;

import java.io.*;

/**
 * Created by Shen Peihong on 2020/9/26 16:16
 */

public class IOTest {


    @Test
    public void test1() throws Exception {
        //指向文件
        File file = new File("d:\\temp\\123.txt");
        //创建管道
        InputStream inputStream = new FileInputStream(file);
        //定义字节数组接收管道数据
        byte[] bytes = new byte[64];
        int length = inputStream.read(bytes);
        //InputStream objectInputStream = new ObjectInputStream(inputStream);
        String s = new String(bytes, "utf-8");
        char[] chars = s.toCharArray();
        int length1 = chars.length;
        for (int i= 0;i<length1;i++){
            if (chars[i] == '\n'){
                System.out.println("沈培泓");
            }
            System.out.println(chars[i]);
        }

    }

    //读取IO流管道里面的数据需要使用字节数组接收
    //字节数组里面的数据都是使用ISO8856进行编码的，需要我们new String(bytes, "utf-8") 重新编码
    @Test
    public void test2() throws Exception {
        File file = null;
        InputStream inputStream = null;
        try{
            //指向文件
            file = new File("d:\\temp\\123.txt");
            //创建管道
            inputStream = new FileInputStream(file);
            int i;
            while ((i = inputStream.read())!=-1){ //调用read()方法读取到的字符是读取到它的ascii码值
                System.out.println(i);
            }
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
        }
    }

    /**
     * 文件输出流
     */
    @Test
    public void test3() throws Exception{
        File file = new File("d:\\temp\\aaa.txt");
        OutputStream outputStream = null;
        try{
            if (!file.exists()){
                //若指向文件不存在，则新建文件
                boolean isSuccess = file.createNewFile();
                //判断新建文件夹是否成功
                if (isSuccess){
                    System.out.println("文件创建成功，继续下一步");
                    //创建输出管道
                    outputStream = new FileOutputStream(file);
                    String s = "我是要打字出来的文字啦";
                    byte[] bytes = s.getBytes();//将字符串转换成字节数组
                    outputStream.write(bytes);//将字节数组写入输出管道,进而会传到指向的文件中
                    outputStream.flush();//输出完毕后要刷新一下输出流，防止输出流仍然有数据
                }else{
                    System.out.println("异常了，新建异常了");
                    throw new Exception("抛异常了喂");
                }
            }
        }finally {
            if (outputStream!=null){
                outputStream.close();
            }
        }
    }

    /**
     * 对象输出流 都是字节流的子类，  writeObject可以直接写入对象，会自动进行序列化
     * 如果不自动进行序列化的话，那么得自己手动转二进制数组， 后面取出来后是一个二进制数组，还得自己转成对象
     */
    @Test
    public void test4() throws IOException {
        File file = new File("d:\\temp\\bbb.txt");
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            UserParam userParam = new UserParam();
            userParam.setId("111");
            userParam.setUsernmae("张三");
            objectOutputStream.writeObject(userParam);
            objectOutputStream.flush();
        }finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
            if (fileOutputStream!=null){
                fileOutputStream.close();
            }
        }

    }

    /**
     * 对象输入流
     */
    @Test
    public void test5() throws Exception {
        File file = new File("d:\\temp\\bbb.txt");
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            UserParam userParam = new UserParam();
            userParam.setId("111");
            userParam.setUsernmae("张三");
            UserParam o = (UserParam)objectInputStream.readObject();
            System.out.println(o);
        }finally {
            if (objectInputStream!=null){
                objectInputStream.close();
            }
            if (fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }

    /**
     * 使用输入/输出缓冲流
     */
    @Test
    public void test6() throws IOException {
        //指向文件
        FileInputStream fis = new FileInputStream("d:\\temp\\ccc.txt");
        //创建管道---输入缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[100]; //读取数据的字节数组
        //读取文件
        int read = bis.read(bytes);
        System.out.println(read);
        String s = new String(bytes);
        System.out.println(s);
    }

    /**
     * 使用输入/输出缓冲流
     */
    @Test
    public void test7() throws IOException {
        //指向文件
        FileOutputStream fos = new FileOutputStream("d:\\temp\\ccc.txt");
        //创建管道---输入缓冲流
        BufferedOutputStream bis = new BufferedOutputStream(fos);
        String s = "删打算的撒";
        byte[] bytes = s.getBytes();
        //byte[] bytes = new byte[100]; //读取数据的字节数组
        //读取文件
        bis.write(bytes);
        bis.flush();//迫使所有缓冲的输出数据被写出到底层输出流中

    }

    /**
     * 输出字符流
     */
    @Test
    public void test8() throws IOException {
        //指向文件
        File file = new File("d:\\temp\\ddd.txt");
        FileReader fr = new FileReader(file);
        char[] c = new char[100];
        int read = fr.read(c);
        String s = new String(c);
        System.out.println(s);
    }

    /**
     * 输入字符流
     * 字符流相较于字节流就是输入输出的数据单位是字符 而不用再转换成字节了
     * 字节流提供的ObjectOutputStream 可以直接传对象  里面帮忙进行序列化了
     */
    @Test
    public void test9() throws IOException {
        //指向文件
        File file = new File("d:\\temp\\ddd.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("叼你妈的，我现在不用写字节了，相当于不用再去转字节数组了，曹你妈");
        fw.flush();
    }


    // --- - -- - - - -- - - -- - -- - - - -- 再次练习IO流 深入理解

    //输出流 不加处理流
    @Test
    public void test10(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("d:\\temp\\IO流练习demo\\123.txt");
            fos.write("是我吗5555？".getBytes());
            //fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          if (fos != null){
              try {
                  fos.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        }
    }

    //输出流 + 输出处理流(缓冲流)
    @Test
    public void test11() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream("d:\\temp\\IO流练习demo\\1234.txt");
            bos = new BufferedOutputStream(fos);
            bos.write("是我吗？6666".getBytes());
            //bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



}
