package com.sph.practice.test.markdown.io.poi;

import com.google.common.collect.Lists;
import com.sph.practice.test.param.POIVO;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/10/24 2:09
 * Description: POI相关操作
 *
 * @since 1.0.0
 */
public class POITest {


    /**
     * 需求一、导出1行1列的数据到D盘的某个文件下  (无样式)
     */
    @Test
    public void test1() {
        FileOutputStream fos = null;
        Workbook workbook = null;
        try {
            //输出流指定某个文件路径
            fos = new FileOutputStream(new File("D:\\temp\\IO流练习demo\\POI\\poi1.xlsx"));
            //创建工作簿对象
            workbook = new SXSSFWorkbook();
            //创建该工作簿的sheet表
            Sheet sheet = workbook.createSheet("sheet1");
            //创建该sheet表的某行
            Row row0 = sheet.createRow(0);
            //创建该行的某个单元格
            Cell cell00 = row0.createCell(0);
            //给该单元格设置值
            cell00.setCellValue("00单元格测试");
            //将工作簿输出到文件输出流指定的文件地址
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 需求一、导出1行1列的数据到D盘的某个文件下  (有样式)
     *
     */
    @Test
    public void test2() {
        FileOutputStream fos = null;
        Workbook workbook = null;
        try {
            fos = new FileOutputStream(new File("D:\\temp\\IO流练习demo\\POI\\poi2.xlsx"));
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("sheet1");
            //导出表头
            this.exportTitle(sheet);
            //处理将要导出的list数据
            this.exportHandleData(sheet, this.getPOITestData(), "子账户");
            //合并单元格指定开始行，结束行， 开始列，结束列
            CellRangeAddress cellRangeAddress = new CellRangeAddress(1, 3, 0, 0);
            sheet.addMergedRegion(cellRangeAddress);
            //将工作簿输出到文件输出流指定的文件地址
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 提供POI相关的初始数据
     * @return
     */
    private List<POIVO> getPOITestData() {
        return new ArrayList<POIVO>() {
            {
                add(new POIVO("1", "12", "123", "123"));
                add(new POIVO("2", "45", "456", "456"));
                add(new POIVO("3", "78", "789", "789"));
            }
        };
    }

    /**
     * 导出表头
     * @param sheet 指定表
     */
    private void exportTitle(Sheet sheet){
        Row writeRow = sheet.createRow(0);
        int columnIndex = 0;
        writeRow.createCell(columnIndex++).setCellValue("模块");
        writeRow.createCell(columnIndex++).setCellValue("序号");
        writeRow.createCell(columnIndex++).setCellValue("标题");
        writeRow.createCell(columnIndex++).setCellValue("账号");
        writeRow.createCell(columnIndex++).setCellValue("密码");
    }

    //处理将要导出的List数据

    /**
     * 处理将要导出的List数据
     * @param sheet 待处理的表
     * @param VOList 待导出的数据
     * @param module 模块名
     */
    private void exportHandleData(Sheet sheet, List<POIVO> VOList, String module){
        //遍历list的数据，填充每一行数据
        int rowIndex = 1, columnIndex = 1;
        //设置模块名(待合并单元格)
        for (POIVO vo : VOList) {
            Row writeRow = sheet.createRow(rowIndex);
            writeRow.createCell(0).setCellValue(module);
            writeRow.createCell(columnIndex++).setCellValue(vo.getId());
            writeRow.createCell(columnIndex++).setCellValue(vo.getTitle());
            writeRow.createCell(columnIndex++).setCellValue(vo.getUsername());
            writeRow.createCell(columnIndex++).setCellValue(vo.getPassword());
            rowIndex += 1;
            columnIndex = 1;
        }
    }

    //导入demo
    /*
        导入，使用List<POI>去接收值
        3行4列，需要判断列数是否超过10行，超过则抛异常
     */
    @Test
    public void importExcel(){
        FileInputStream fis = null;
        SXSSFWorkbook workbook = null;
        try {
            fis = new FileInputStream("D:\\temp\\IO流练习demo\\POI\\poi3.xlsx");
            workbook = new SXSSFWorkbook();
            Sheet sheet = workbook.getSheet("sheet1");
            //二重for循环 遍历行、列，   需要获得最大行和最大列
            //然后使用List<POI>去add接收一个POI对象类型
            List<POIVO> voList = new ArrayList<>();
            int readColumn = 0;
            for (int readRow = 1; readRow < sheet.getLastRowNum(); readRow++) {
                POIVO vo = new POIVO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 汇总一些POI常用的方法
     */
    @Test
    public void commonUseMethod(){
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.getSheetAt(0);
        int firstRowNum = sheet.getFirstRowNum();//获得sheet表第一行的行数
        int lastRowNum = sheet.getLastRowNum();//获得sheet表最后一行的行数
        int lastColumnNum = sheet.getPhysicalNumberOfRows();//获得sheet表最后一列的列数
    }




}
