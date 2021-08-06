package com.sph.practice.component.boot.kafka.constant;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
public class TopicConstant {

    // 人脸图片抓拍（公安系统 -》 广电）
    public static final String TOPIC_PassersByCapture = "SIBAT-POLICE-FACE-IMG";

    // 新增布控人员（公安系统 -》 广电）
    public static final String SIBAT_KEY_PERSON_CORRELATION = "SIBAT-KEY-PERSON-CORRELATION";

    // 删除布控人员（公安系统 -》 广电）
    public static final String SIBAT_KEY_PERSON_CORRELATION_DELETE = "SIBAT-KEY-PERSON-CORRELATION-DELETE";

    // 同步布控人员（公安系统 -》 广电）
    public static final String SIBAT_GRG_KEY_PERSON_CORRELATION_ALL = "SIBAT-GRG-KEY-PERSON-CORRELATION-ALL";

    // 对账差异人员（公安系统 -》 广电）
    public static final String SIBAT_KEY_PERSON_CORRELATION_GRG_SYN = "SIBAT-KEY-PERSON-CORRELATION-GRG-SYN";

    // 新增、初始化布控人员（品高大数据平台->安检平台）
    public static final String GZMETRO_GRG_ANJIAN_FEATURE_ADD = "GZMETRO_GRG_ANJIAN_FEATURE_ADD";

    // 删除布控人员（品高大数据平台->安检平台）
    public static final String GZMETRO_GRG_ANJIAN_FEATURE_DEL = "GZMETRO_GRG_ANJIAN_FEATURE_DEL";

    // 全量对账（品高大数据平台->安检平台）
    public static final String FEATURE_START = "FEATURE_START";

    //
    public static final String TOPIC_GROUP1 = "topic.group1";

    //
    public static final String TOPIC_GROUP2 = "topic.group2";

}
