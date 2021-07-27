package com.sph.practice.component.boot.kafka.constant;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
public class TopicConstant {

    // 人脸图片抓拍
    public static final String TOPIC_PassersByCapture = "SIBAT-POLICE-FACE-IMG";

    // 新增布控人员
    public static final String SIBAT_KEY_PERSON_CORRELATION = "SIBAT-KEY-PERSON-CORRELATION";

    // 删除布控人员
    public static final String SIBAT_KEY_PERSON_CORRELATION_DELETE = "SIBAT-KEY-PERSON-CORRELATION-DELETE";

    // 同步布控人员
    public static final String SIBAT_GRG_KEY_PERSON_CORRELATION_ALL = "SIBAT-GRG-KEY-PERSON-CORRELATION-ALL";

    // 对账差异人员
    public static final String SIBAT_KEY_PERSON_CORRELATION_GRG_SYN = "SIBAT-KEY-PERSON-CORRELATION-GRG-SYN";

    //
    public static final String TOPIC_GROUP1 = "topic.group1";

    //
    public static final String TOPIC_GROUP2 = "topic.group2";

}
