package com.sph.practice.test.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class Demo_InputExcel {
    public static void main(String[] args) throws Exception {
        //Workbook是整个POI的祖先接口，想用什么office 使用对应的子类去创建对象即可。
        InputStream input = new FileInputStream("d:\\file\\input.xls");
        POIFSFileSystem fs = new POIFSFileSystem(input);//该构造方法实参为输入流
        Workbook workbook = new HSSFWorkbook(fs);//输入到Java的话 直接在构造方法形参写输入流呢
        //Workbook workbook1 = new HSSFWorkbook(input);  //这种方法也可以，实现的方法不同罢了 这个占用的内存大点
        Sheet sheet1 = workbook.getSheet("sheet1");//获得sheet1表格
        int firstRowNum = sheet1.getFirstRowNum();//获得sheet1表第一行的行数
        int lastRowNum = sheet1.getLastRowNum();//获得sheet1表最后一行的行数



    }
}
