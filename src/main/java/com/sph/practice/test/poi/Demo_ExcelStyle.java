package com.sph.practice.test.poi;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class Demo_ExcelStyle {
    public static void main(String[] args) throws Exception {
        Workbook workbook = new HSSFWorkbook();
        //CellStyle类有自身的构造方法创建对象，但是我们的Workbook也有封装方法去创建该类类型的变量
        //Workbook接口中封装了方法createCellStyle，是CellStyle类型的 则对象cellStyle就可以调用CellStyle类里面的方法了
        //所以相当于Workbook类封装的方法createCellStyle(),就是为了创建单元格样式对象，想设计的样式就可以封装到这个对象当中
        //到时候我们哪个单元格想要这个样式的话，再把这个封装的对象传进去对应的方法参数即可
        CellStyle cellStyle = workbook.createCellStyle();//工作簿调用创建一个单元格样式 通过cellStyle来更改工作簿
        CreationHelper creationHelper = workbook.getCreationHelper();
        //设置工作簿的单元格样式 - - - 日期格式
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd hh:MM:ss"));
        //上面已封装好了对象  单元格格式 - - - 日期格式

        Sheet sheet1 = workbook.createSheet("sheet1");
        Row row = sheet1.createRow(0);
        Cell cell = row.createCell(0);
        //下面两行是先给单元格赋值还是给单元格设置样式都无所谓 反正给单元格设置样式的时候，已经规定好这个单元格的格式了
        cell.setCellStyle(cellStyle);
        cell.setCellValue(new Date());

        //下面给第1行的单元格赋值并且操作样式
        row = sheet1.createRow(1);
        cell = row.createCell(0); //这个是引用类型，改变指向即可， 但是不可以重新再创建对象哦
        cell.setCellValue("第2行的第一个值");
        CellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setBorderBottom(HSSFCellStyle.ALIGN_CENTER);
        System.out.println(workbook.getNumberOfSheets());//取得工作簿的sheet数量
        Sheet sheet2 = workbook.getSheetAt(0); //通过索引来获得工作簿的第几张sheet

        cell.setCellStyle(cellStyle1);
        if(1==1){
            sheet1 = workbook.createSheet("sheet2");
        }
        OutputStream output = new FileOutputStream("d:\\file\\工作簿2434.xls");
        workbook.write(output);
    }
}
