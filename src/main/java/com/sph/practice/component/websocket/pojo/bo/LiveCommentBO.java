package com.sph.practice.component.websocket.pojo.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 直播评论BO
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class LiveCommentBO implements Serializable {

    /**
     * 直播ID
     */
    private String liveId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 评论内容
     */
    private String message;
}
