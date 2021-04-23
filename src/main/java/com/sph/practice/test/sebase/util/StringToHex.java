package com.sph.practice.test.sebase.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import com.sph.practice.test.bean.TimeEnm;

import java.io.UnsupportedEncodingException;

/**
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/4/22
 */
public class StringToHex {

    public String convertStringToHex(String str){

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }

        return hex.toString();
    }

    public String convertHexToString(String hex){

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ){

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char)decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }

    //504F533838383834  POS88884
    public static void main(String[] args) {

        StringToHex strToHex = new StringToHex();
        System.out.println("\n-----ASCII码转换为16进制 -----");
        String str = "68";
        System.out.println("字符串: " + str);
        String hex = strToHex.convertStringToHex(str);
        System.out.println("转换为16进制 : " + hex);

        System.out.println("\n***** 16进制转换为ASCII *****");
        System.out.println("Hex : " + hex);
        System.out.println("ASCII : " + strToHex.convertHexToString(hex));
    }

    /**
     *
     */
    @Test
    public void test(){
        StringToHex strToHex = new StringToHex();
        String hex = "8e";
        String s = strToHex.convertHexToString(hex);
        System.out.println(s);
    }


    /**
     * 01111111
     */
    @Test
    public void test1() throws UnsupportedEncodingException {
        String str = "张三";
        byte[] bytes = str.getBytes();
        byte[] bytes1 = JSON.toJSONBytes(str);
        System.out.println(bytes);
        System.out.println(bytes1);
        System.out.println(bytes.length);
        System.out.println(bytes1.length);
    }

}
