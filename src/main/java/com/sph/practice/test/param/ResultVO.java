package com.sph.practice.test.param;

/**
 * Created by Shen Peihong on 2020/9/28 18:12
 * Description: 返回值
 *
 * @since 1.0.0
 */
public class ResultVO {
    private String code = "0";//暂时写死默认返回0
    private String desc = "successful"; //暂时写死
    private Object result;//返回给前端的值

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
