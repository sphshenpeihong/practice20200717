package com.sph.practice.mybatis.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by Shen Peihong on 2020/12/30 15:53
 * Description:
 *
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class QyTestPO {
    private Integer id;
    //@JSONField(format = "yyyy-MM-dd")
    private Date date1;

    //@JSONField(format = "HH-mm-ss")
    private Date time1;

    //@JSONField(format = "HH-mm-ss")
    private Date datetime1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public void setDatetime1(Date datetime1) {
        this.datetime1 = datetime1;
    }

}
