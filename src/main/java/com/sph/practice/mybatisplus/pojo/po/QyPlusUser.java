package com.sph.practice.mybatisplus.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


/**
 * Created by Shen Peihong on 2021/1/26
 * Description:
 *
 * @since 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QyPlusUser {
    /*
        AUTO(0),            //自增，需要数据库设置自增才有效
        NONE(1),            //不做 任何操作
        INPUT(2),           //自己手动set Id了
        ID_WORKER(3),       //利用雪花算法自动生成ID，并且会回填
        UUID(4),            //生成UUID
        ID_WORKER_STR(5);
     */
    // MP提供了很多主键生成策略，只需要你在实体类的id上面加个注解指定后
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public QyPlusUser(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

