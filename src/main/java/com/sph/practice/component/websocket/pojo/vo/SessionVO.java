package com.sph.practice.component.websocket.pojo.vo;

import lombok.Data;

import javax.websocket.Session;
import java.io.Serializable;

/**
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/8
 */
@Data
public class SessionVO implements Serializable {

    private String userId;
    private Session session;

}
