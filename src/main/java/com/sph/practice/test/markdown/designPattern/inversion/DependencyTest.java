package com.sph.practice.test.markdown.designPattern.inversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Shen Peihong on 2020/11/18 0:39
 * Description: 练习依赖倒置原则，并练习其三种方式
 *
 * @since 1.0.0
 */
public class DependencyTest {

    /**
     * 使用URL解码
     */
    @Test
    public void test1() throws UnsupportedEncodingException {
        //String str = "https://jwoa.shdata.com/portal/portal/portalForm/tryInitApp.do?appCode=1&agentCode=learnonline&orgId=0223392f-634f-4f1a-b82e-b9d8dfe6729c&authJson=[%7B%22type%22:0,%22functionCode%22:%22design_high_instance_title%22,%22vipLevel%22:0,%22hiddenAttr%22:0%7D,%7B%22type%22:0,%22functionCode%22:%22design_field_member%22,%22vipLevel%22:0,%22hiddenAttr%22:0%7D,%7B%22type%22:0,%22functionCode%22:%22design_field_dept%22,%22vipLevel%22:0,%22hiddenAttr%22:0%7D,%7B%22type%22:0,%22functionCode%22:%22design_flow_fix%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_flow_branch%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_type_general%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_type_task%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_type_open%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_submit_limit_all_num%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_submit_limit_everyone_num%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:1,%22functionCode%22:%22design_remind_tab%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:1,%22functionCode%22:%22portal_order_roll_page%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_flow_type%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D,%7B%22type%22:0,%22functionCode%22:%22design_flow_open%22,%22vipLevel%22:0,%22hiddenAttr%22:1%7D]";
        //String decode = URLDecoder.decode(str, "utf-8");
        //System.out.println(decode);

        String str = "https://jwoa.shdata.com/portal/portal/portalForm/tryInitApp.do?appCode=1&agentCode=learnonline&orgId=0223392f-634f-4f1a-b82e-b9d8dfe6729c&authJson=[{%22type%22:0,%22functionCode%22:%22design_high_instance_title%22,%22vipLevel%22:0,%22hiddenAttr%22:0}]";
        String decode = URLDecoder.decode(str, "utf-8");
        System.out.println(decode);

    }

    /**
     * 转json字符串
     */
    @Test
    public void test2(){
        JSONObject json = new JSONObject();
        json.put("orgId", "0223392f-634f-4f1a-b82e-b9d8dfe6729c");
        json.put("appCode", "1");
        json.put("agentCode", "learnonline");
        json.put("authJson", "[{\"type\":0,\"functionCode\":\"design_high_instance_title\",\"vipLevel\":0,\"hiddenAttr\":0},{\"type\":0,\"functionCode\":\"design_field_member\",\"vipLevel\":0,\"hiddenAttr\":0},{\"type\":0,\"functionCode\":\"design_field_dept\",\"vipLevel\":0,\"hiddenAttr\":0},{\"type\":0,\"functionCode\":\"design_flow_fix\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_flow_branch\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_type_general\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_type_task\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_type_open\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_submit_limit_all_num\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_submit_limit_everyone_num\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":1,\"functionCode\":\"design_remind_tab\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":1,\"functionCode\":\"portal_order_roll_page\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_flow_type\",\"vipLevel\":0,\"hiddenAttr\":1},{\"type\":0,\"functionCode\":\"design_flow_open\",\"vipLevel\":0,\"hiddenAttr\":1}]");

        String str = JSON.toJSONString(json);
        System.out.println(str);
    }


    /**
     *
     */
    @Test
    public void test4(){
        OpenAndClose openAndClose = new OpenAndClose();
        //调接口的时候，需要传递依赖对象   -- > 形参
        openAndClose.open(new Changhong());
    }


}

//定义开关接口，定义打开方法和关闭方法
interface IOpenAndClose{
    //定义打开接口
    void open(ITV itv);

    //定义关闭接口
    void close(ITV itv);
}

class OpenAndClose implements IOpenAndClose{

    @Override
    public void open(ITV itv) {
        itv.play();
    }

    @Override
    public void close(ITV itv) {
        itv.down();
    }
}


//定义电视接口，定义运行电视的方法和关闭电视的方法
interface ITV{
    //运行电视
    void play();

    //关闭电视
    void down();
}

class Changhong implements ITV{

    @Override
    public void play() {
        System.out.println("打开了长虹电视机");
    }

    @Override
    public void down() {
        System.out.println("关闭了长虹电视机");
    }
}
