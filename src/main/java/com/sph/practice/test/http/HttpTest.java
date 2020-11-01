package com.sph.practice.test.http;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/10/30 15:08
 * Description:
 *
 * @since 1.0.0
 */
public class HttpTest {

    /**
     * 发起请求
     */
    @Test
    public void test1(){
        String str = HttpUtil.get("https://zgjtxxzx.gov.weixin.qq.com/cgi-bin/gettoken?corpid=wl84b89b9a7a&corpsecret=pHnc6dH355AybTE_hmssxf_3cv3iM7COfjcmr21i8tU");
        JSONObject jsonObject = JSON.parseObject(str);
        if (jsonObject.get("access_token") != null){
            String access_token = (String)jsonObject.get("access_token");
            System.out.println(access_token);
        }
    }

}
