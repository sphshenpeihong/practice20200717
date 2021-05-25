package com.sph.practice.test.poi;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shenpeihong
 * @date 2019/12/6 09:54:06
 * @description
 */
public class exportExcel {
    public static void main(String[] args) throws Exception {
        //exportExcel1();
        //selectDate();
    }

    static void exportExcel1() throws IOException {
        Workbook workbook = new SXSSFWorkbook(500);
        CellStyle cellStyle = workbook.createCellStyle();//设置列的样式
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Sheet sheet = workbook.createSheet("补录模板");
        sheet.autoSizeColumn(0); //设置表的列宽
        sheet.setColumnWidth(0, sheet.getColumnWidth(0)*20/10);
        sheet.autoSizeColumn(1);
        sheet.setColumnWidth(1, sheet.getColumnWidth(1)*22/10);
        sheet.autoSizeColumn(2);
        sheet.setColumnWidth(2, sheet.getColumnWidth(2)*30/10);
        sheet.autoSizeColumn(3);
        sheet.setColumnWidth(3, sheet.getColumnWidth(3)*37/10);
        sheet.autoSizeColumn(4);
        sheet.setColumnWidth(4, sheet.getColumnWidth(4)*37/10);
        sheet.autoSizeColumn(5);
        sheet.setColumnWidth(5, sheet.getColumnWidth(5)*19/10);
        sheet.autoSizeColumn(6);
        sheet.setColumnWidth(6, sheet.getColumnWidth(6)*12/10);
        sheet.autoSizeColumn(7);
        sheet.setColumnWidth(7, sheet.getColumnWidth(7)*37/10);
        Row row0 = sheet.createRow(0);//创建第一行
        Cell cell00 = row0.createCell(0);
        Cell cell01 = row0.createCell(1);
        Cell cell02 = row0.createCell(2);
        Cell cell03 = row0.createCell(3);
        Cell cell04 = row0.createCell(4);
        Cell cell05 = row0.createCell(5);
        Cell cell06 = row0.createCell(6);
        Cell cell07 = row0.createCell(7);
        cell00.setCellValue("账号");
        cell01.setCellValue("考勤日期");
        cell02.setCellValue("第一次签到时间");
        cell03.setCellValue("第一次签到时的设备号码");
        cell04.setCellValue("第一次签到地址");
        cell05.setCellValue("第一次签到ip");
        cell06.setCellValue("第一次签到备注");
        cell07.setCellValue("第一次签退时间");
        int j = 0; //j代表列
        //设置第一列的数据
        for (int i = 1; i < 300; i++) {
            Cell tempCell = sheet.createRow(i).createCell(j);
            tempCell.setCellValue("15812481225");
            tempCell.setCellStyle(cellStyle);
        }

        j = 1;
        //第二列想输出考勤日期 2019 01 07 到 2019 12 06 除去周末休息 和 法定节假日
        for (int i = 1; i < 300; i++) {
            Cell tempCell = sheet.createRow(i).createCell(j);
            tempCell.setCellValue("15812481225"); //String类型的值， 这里等会写一个函数，直接获取规定好的日期
            tempCell.setCellStyle(cellStyle);
        }

        OutputStream outputStream = new FileOutputStream("D:\\file\\补录模板1.xls");
        workbook.write(outputStream);
    }

    //1先完成日期
    static String[] selectDate() throws Exception {
        String[] str= {""};
        Calendar beginDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        beginDate.set(2019, 0, 16, 8, 54, 6);
        endDate.set(2019, 11, 6, 8, 59, 50);
        String[] s = lastDate(beginDate,endDate);
        /* 最后获取到时间再进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String beginFormatDate = sdf.format(beginDate.getTime());
        String endFormatDate = sdf.format(endDate.getTime());
         */

        return str;
    }

    //2.完成日期的筛选与剔除
    static String[] lastDate(Calendar beginDate,Calendar endDate){
        String[] s = {""};
        while(beginDate.getTime().getTime() <= endDate.getTime().getTime()){
            if (beginDate.get(Calendar.DATE) != Calendar.SUNDAY && beginDate.get(Calendar.DATE) != Calendar.SATURDAY );
        }
        return s;
    }

    //这个等会时间需要调用
    static long random(Date beginFormatDate,Date endFormatDate){
        long temp = 1;
        //Random random = new Random(1);
        long v = (long)(beginFormatDate.getTime() + Math.random() * (endFormatDate.getTime() - beginFormatDate.getTime()));
        System.out.println(v);
        return temp;
    }

    /**
     *
     */
    @Test
    public void test1(){
        String str = "/";
        String str1 = "\\12";
        System.out.println();
    }
}
