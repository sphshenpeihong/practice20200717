package com.sph.practice.test.markdown.io;

import com.sph.practice.test.bean.User1;
import org.junit.Test;

import java.io.*;

/**
 * Created by Shen Peihong on 2020/10/23 22:37
 * Description: 文件 与 IO流的数据传输
 *
 * @since 1.0.0
 */
public class FileIOTest {

    /**
     * 输出字节数据到D盘文件中
     */
    @Test
    public void test1() {
        File file = null;
        OutputStream fos = null;
        OutputStream bos = null;
        try {
            //指向该路径的某个文件或文件夹，若无该文件/文件夹会新建一个 （此时管道已建好）
            file = new File("D:\\temp\\IO流练习demo\\file1.txt");
            //获取输出流对象
            fos = new FileOutputStream(file);
            //获取输出流的缓冲输出流对象 （相当于嵌套一层）
            bos = new BufferedOutputStream(fos);
            byte[] bytes = "输出数据".getBytes();
            //将数据写入缓冲流
            bos.write(bytes);
            //刷新缓冲流，若这里不刷新的话，那么缓冲流会等满的时候才会往指定文件传输
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //数据传输完毕需要关闭管道
                if (bos != null) bos.close();
                if (fos != null) bos.close();
                if (file != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 输入流读取D盘文件的数据
     */
    @Test
    public void test2(){
        File file = null;
        InputStream fis = null;
        InputStream bis = null;
        try {
            //指向文件
            file = new File("D:\\temp\\IO流练习demo\\input2.txt");
            //获取文件输入流
            fis = new FileInputStream(file);
            //获取文件输入缓冲流
            bis = new BufferedInputStream(fis);
            //定义字节数组待接收输入字节数据
            byte[] bytes = new byte[1024];
            //读取输入字节数据
            int length = bis.read(bytes);
            if (length!=0){
                //字节数组转String类型
                String str = new String(bytes, 0, length);
                System.out.println(str);
                /*
                    输入数据
                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis!=null) bis.close();
                if (fis!=null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用处理流(处理序列化问题)，不需要再通过转字节数组了
     * ObjectOutputStream
     */
    @Test
    public void test3() {
        OutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //获取文件输出流对象
            fos = new FileOutputStream("D:\\temp\\IO流练习demo\\objectOutputStream.txt");
            //获取处理流对象（对象输出流 相当于内层嵌套了文件输出流）
            oos = new ObjectOutputStream(fos);
            User1 user1 = new User1("zhangsan", "123456");
            //写入对象
            oos.writeObject(user1);
            //写入的时候，在txt文件呈现的也是二进制数据来的，只不过传输过程我们使用了处理流(封装流)
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用对象输入流（处理流来的）
     */
    @Test
    public void test4() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("D:\\temp\\IO流练习demo\\objectOutputStream.txt");
            ois = new ObjectInputStream(fis);
            User1 user1 = (User1) ois.readObject();
            System.out.println(user1);
            /*
                User1{id=null, username='zhangsan', password='123456', parentId=null, score=null}
             */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 输出字符流
     */
    @Test
    public void test5(){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            //指向文件字符输出流
            fileWriter = new FileWriter("D:\\temp\\IO流练习demo\\writer.txt");
            //使用文件字符缓冲输出流
            bufferedWriter = new BufferedWriter(fileWriter);
            //待写入的字符串
            String str = "张三的歌";
            bufferedWriter.write(str, 0, str.length());
            //刷新缓冲区
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) bufferedWriter.close();
                if (fileWriter != null) fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 输入字符流
     */
    @Test
    public void test6() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("D:\\temp\\IO流练习demo\\writer.txt");
            bufferedReader = new BufferedReader(fileReader);
            String str = null;
            int i = 0;
            //读取字符对象只有获取一行的api，所以需要用while循环遍历取出来
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println("当前行号为：" + (++i) + "，内容为：" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
