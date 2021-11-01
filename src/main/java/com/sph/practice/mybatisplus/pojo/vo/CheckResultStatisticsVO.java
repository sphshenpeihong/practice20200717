package com.sph.practice.mybatisplus.pojo.vo;

import lombok.Data;

/**
 * 物检统计
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class CheckResultStatisticsVO {

    /**
     * 判图员数量
     */
    private Integer judgementPerson;

    /**
     * 过包总数
     */
    private Integer passPack;

    /**
     * 已完成判图数
     */
    private Integer completeJudgement;

    /**
     * 开包总数
     */
    private Integer unpack;

    /**
     * 分配失败
     */
    private Integer dispatcherError;

    /**
     * 超时处理
     */
    private Integer overtimeHandle;

    /**
     * 已处理开包数
     */
    private Integer handledUnpack;

    /**
     * 平均分配调度时长
     */
    private Float avgDispatcherTime;
}
