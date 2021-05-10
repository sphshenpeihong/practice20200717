package com.sph.practice.component.websocket.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Session;

/**
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/8
 */
@Data
public class SessionVO {

    private String userId;
    private Session session;

}
