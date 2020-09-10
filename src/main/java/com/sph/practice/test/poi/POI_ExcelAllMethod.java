package com.sph.practice.test.poi;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class POI_ExcelAllMethod {
    public static void main(String[] args) throws Exception {
        //输出表
        Workbook workbook = new HSSFWorkbook();//新建Java工作簿
        Sheet sheet1 = workbook.createSheet("sheet1");//给这张工作簿创建一张sheet并且取名字
        Sheet sheet2 = workbook.createSheet("sheet2");
        Row row = sheet1.createRow(0);//给这张sheet创建第0行
        Row row1 = sheet1.createRow(1);//创建第1行
        Row row2 = sheet1.createRow(2);//创建第2行
        Cell cell00 = row.createCell(0);//给这一行创建第0个单元格
        Cell cell01 = row.createCell(1);//创建第0行的第1列
        Cell cell02 = row.createCell(2);//创建第0行的第2列
        cell01.setCellValue("我是第0行的第1列");
        cell02.setCellValue("我是第0行的第2列");
        cell00.setCellValue("我是第0行的第0列");//给这个单元格赋值 (第0行第0列)
        Cell cell10 = row1.createCell(0);
        cell10.setCellValue("我是第1行的第0列");
        Cell cell13 = row1.createCell(3);//创建单元格 第1行第3列
        cell13.setCellValue(2.2222);
        CellRangeAddress region = new CellRangeAddress(0, 1, 1, 2);
        sheet1.addMergedRegion(region);//给表格添加需要合并的区域

        CellStyle cellStyle = workbook.createCellStyle();//通过工作簿封装的方法 新建单元格样式对象
        //下面开始封装单元格样式对象 到时候哪个需要此样式的单元格直接setCellStyle(cellStyle)即可
        cellStyle.setBorderBottom(HSSFCellStyle.ALIGN_CENTER);//HSSFCellStyle里面定义了许多静态变量 设置下边框样式
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置样式 水平居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置样式 垂直居中
        DataFormat dataFormat = workbook.createDataFormat();//由于HSSFDataFormar构造方法不是public 只能用工作簿去获取格式化构造方法
        cellStyle.setDataFormat(dataFormat.getFormat("0.0")); //由于setDataFormat()是short类型，所以我们使用getFormat()也要选short类型的
        Font font = workbook.createFont();//使用工作簿创建字体对象
        font.setColor(HSSFColor.RED.index); //给字体对象封装红色颜色
        cellStyle.setFont(font);//设置单元格样式 - - - 字体
        cell13.setCellStyle(cellStyle);//给这个单元格设置上面封装的单元格样式
        cell01.setCellStyle(cellStyle);//给这个单元格设置上面封装的单元格样式

        //设置表的行高列宽
        System.out.println(workbook.getNumberOfSheets());//获取该工作簿的sheet表数量
        Sheet sheet = workbook.getSheetAt(1); //获得该工作簿指定的第几张表
        sheet.setDefaultColumnWidth(2000);//设置指定sheet的默认列宽
        sheet.setDefaultRowHeight((short)2000);//设置指定sheet的默认行高
        System.out.println("备注"+sheet1.getPhysicalNumberOfRows());
        OutputStream output = new FileOutputStream("d:\\file\\方法汇总.xls");//定义文件输出流
        workbook.write(output);//把工作簿输出到文件输出流指定的位置
    }
}
