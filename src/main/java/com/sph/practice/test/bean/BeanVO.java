package com.sph.practice.test.bean;

import com.sph.practice.test.param.BankVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Created by Shen Peihong on 2020/12/19 22:33
 * Description: 该VO类交给Spring容器管理呢
 *
 * @since 1.0.0
 */
public class BeanVO extends ParentBeanVO {

    private String id = "1";
    private String username = "zhangsan";
    private String password = "123456";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
