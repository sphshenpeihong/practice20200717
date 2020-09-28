package com.sph.practice.test.controller.ui;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shen Peihong on 2020/9/28 15:13
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mgr/poi")
public class POICtl {

    //前端点击导出按钮，后端利用POI导出excel
    @RequestMapping(path = "/test1.do")
    public void test1(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("测试一下sheet");
        sheet.createRow(0).createCell(0).setCellValue("随便测试一下了");
        OutputStream os = response.getOutputStream();
        response.setHeader("contentType","application/xlsx");
        String s = new String("导出了喂".getBytes(), "ISO-8859-1");
        String init = "初始化";
        String encode = URLEncoder.encode(init, "UTF-8");
        response.setHeader("Content-disposition", "attachment; filename=\"" + encode + ".xls" + "\"");
        //response.setContentType("application/xml");

    }

    //帮助跳转
    @RequestMapping(path = "/test2.do")
    public void test2(HttpServletResponse response) throws IOException {
        //String preUrl = request.getContextPath()+"/jsp/wap/tips/error.html";
        response.sendRedirect("/shop/views/poiTest.jsp");
    }

    /**
     *
     */
    @Test
    public void test(){
        long l = System.currentTimeMillis();
        System.out.println("当前时间戳：" + l);
        Date date = new Date(l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
    }

    @RequestMapping(name = "/test4.do")
    public void test4(HttpServletRequest request){
        //获取请求头 referer的数据
        String referer = request.getHeader("referer");
        System.out.println(referer);
    }

    @RequestMapping(path = "/test10.do")
    public void test10(HttpServletRequest request){
        //获取请求头 referer的数据 作用是直到调接口的地方的前一个页面或接口的全路径
        String referer = request.getHeader("referer");
        String connection = request.getHeader("Connection");
        String host = request.getHeader("Host");
        System.out.println(connection);
        System.out.println(host);
        System.out.println(referer);
    }





}
