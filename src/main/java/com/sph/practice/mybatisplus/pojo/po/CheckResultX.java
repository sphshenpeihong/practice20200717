package com.sph.practice.mybatisplus.pojo.po;

import lombok.Data;

import java.util.Date;

/**
 * X光机数据
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class CheckResultX {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 事件id
     */
    private String eventId;

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 站点id
     */
    private Integer stationId;

    /**
     * 线路id
     */
    private Integer lineId;

    /**
     * x光成像图--主视图
     */
    private String picture;

    /**
     * x光成像图--侧视图
     */
    private String auxiliaryImg;

    /**
     * 报警信息 0：正常  1：开检
     */
    private Integer warning;

    /**
     * 判图员id
     */
    private String detectUserId;

    /**
     * 判图员姓名
     */
    private String detectUserName;

    /**
     * 生成时间（同方）/ 判图完成时间（科大）
     */
    private Date msgCreateTime;

    /**
     * 包裹接收时间
     */
    private Date receiveTime;

    /**
     * 包裹分发时间
     */
    private Date dispatchTime;

    /**
     * 等待超时时间
     */
    private Integer packageWaitTime;

    /**
     * 包裹是否上传完毕
     */
    private Boolean isLast;

    /**
     * 厂家编码
     */
    private Integer manufacturer;

    /**
     * 物检报告发送时间
     */
    private Date msgSendTime;

    /**
     * 开包员id
     */
    private String openUserId;

    /**
     * 开包员姓名
     */
    private String openUserName;

    /**
     * 开检类型 0未知；1处理集中判图推送任务发起开包；2手动添加报警开包；3采集终端发起判图任务
     */
    private Integer checkType;

    /**
     * 开检结果  开检结果 0放行 1自弃  2 暂存 3带回 4收缴 5报警 6误报
     */
    private Integer checkResult;

    /**
     * 判图员检查时间
     */
    private Date checkTime;

    /**
     * 包裹实物图
     */
    private String packagePhoto;

    /**
     * 违带品类型：数组拼接成字符串，用逗号分隔
     */
    private String objectType;

    /**
     * 开检消息发送时间
     */
    private Date msgSendTime1;

    /**
     * 开包视频
     */
    private String videoUrl;

    /**
     * 状态:
     * 0:未处理
     * 1:已处理
     */
    private Integer status;

    /**
     * 开包台拍摄包裹图片
     */
    private String contrabandImg;

    /**
     * 开包台拍摄包裹图片1
     */
    private String contrabandImg1;

    /**
     * 开包台拍摄包裹图片2
     */
    private String contrabandImg2;

    /**
     * 开包台拍摄包裹图片3
     */
    private String contrabandImg3;


}
