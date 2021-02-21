package com.sph.practice.mybatis.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Shen Peihong on 2020/12/30 15:53
 * Description:
 *
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class QyTestPO {
    private Integer id;

    //@JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat
    private Date date1;

    //@JSONField(format = "HH-mm-ss")
    private Date time1;

    //@JSONField(format = "HH-mm-ss")
    private Date datetime1;

    private Float money;

}
