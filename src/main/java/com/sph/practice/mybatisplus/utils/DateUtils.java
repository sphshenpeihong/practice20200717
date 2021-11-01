package com.sph.practice.mybatisplus.utils;

import com.sph.practice.component.exception.BaseException;
import com.sph.practice.mybatisplus.pojo.enm.BaseEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2021/4/6
 * Description: 日期工具类
 *
 * @since 1.0.0
 */
public class DateUtils {

    public static final String pattern = "yyyy-MM-dd HH:mm:ss";

    public static final String patternOfNoSpace = "yyyyMMddHHmmss";

    public static final String patternMillisOfNoSpace = "yyyyMMddHHmmssSSS";

    /**
     * LocalDateTime 转 String
     *
     * @param dateTime 入参
     * @return 返参
     * @author Shen Peihong
     */
    public static String convertLocalDateTimeToString(LocalDateTime dateTime) {
        // 创建格式化器对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern, Locale.CHINESE);
        // 对指定的时间进行进行格式化
        return dateTime.format(dtf);
    }

    /**
     * LocalDateTime 转 String
     *
     * @param dateTime 入参
     * @return 返参
     * @author Shen Peihong
     */
    public static String convertLocalDateTimeToString(LocalDateTime dateTime, String pattern) {
        // 创建格式化器对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern, Locale.CHINESE);
        // 对指定的时间进行进行格式化
        return dateTime.format(dtf);
    }

    /**
     * String 转 LocalDateTime
     *
     * @param dateTime 入参
     * @return 返参
     * @author Shen Peihong
     */
    public static LocalDateTime convertStringToLocalDateTime(String dateTime) {
        // 创建格式化器对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern, Locale.CHINESE);
        // 对String类型进行解析
        return LocalDateTime.parse(dateTime, dtf);
    }

    /**
     * No Space String 转 LocalDateTime
     *
     * @param dateTime 无空格格式 yyyyMMddHHmmss
     * @return 返参
     * @author Shen Peihong
     */
    public static LocalDateTime convertNoSpaceStringToLocalDateTime(String dateTime) {
        // 创建格式化器对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(patternOfNoSpace, Locale.CHINESE);
        // 对String类型进行解析
        return LocalDateTime.parse(dateTime, dtf);
    }

    /**
     * String（格式：yyyyMMddHHmmss） 转 java.util.Date
     *
     * @param dateTime String类型的时间（格式：yyyyMMddHHmmss）
     * @return 返参
     * @author Shen Peihong
     */
    public static Date convertNoSpaceStringToDate(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return null;
        }
        LocalDateTime localDateTime = DateUtils.convertNoSpaceStringToLocalDateTime(dateTime);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    /**
     * 判断开始时间是否晚于结束时间
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return 返参
     */
    public static boolean beginTimeAfterEndTime(String beginTime, String endTime) {
        LocalDateTime begin = DateUtils.convertStringToLocalDateTime(beginTime);
        LocalDateTime end = DateUtils.convertStringToLocalDateTime(endTime);
        return begin.isAfter(end);
    }


    /**
     * 判断开始时间是否晚于结束时间
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean beginTimeAfterEndTime(LocalDateTime beginTime, LocalDateTime endTime) {
        return beginTime.isAfter(endTime);
    }

    /**
     * Date类型转时间戳
     *
     * @param date 入参
     * @return 返参
     * @author Shen Peihong
     */
    public static Long dateToLong(Date date) {
        return date == null ? null : date.getTime();
    }

    /**
     * 两个Date类型的时间相减，求差值（精确到秒）
     *
     * @param before   前一个时刻
     * @param after    后一个时刻
     * @param timeUnit 精确度
     * @author Shen Peihong
     */
    public static long differentDate(Date before, Date after, TimeUnit timeUnit) throws BaseException {
        if (Objects.isNull(before) || Objects.isNull(after)) {
            throw new BaseException(BaseEnum.TIME_IS_NOT_NULL.getCode(), BaseEnum.TIME_IS_NOT_NULL.getDesc());
        }
        long difference = 0L;
        if (timeUnit == TimeUnit.SECONDS) {
            difference = (after.getTime() - before.getTime()) / 1000;
        } else if (timeUnit == TimeUnit.MILLISECONDS) {
            difference = after.getTime() - before.getTime();
        }
        return difference;
    }

    /**
     * Date类型转String类型
     *
     * @param date    Date对象
     * @param pattern 转换格式
     * @return String字符串
     * @author Shen Peihong
     */
    public static String dateToString(Date date, String pattern) {
        if (Objects.isNull(date)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * String（格式：yyyyMMddHHmmssSSS）类型 转 Date类型
     *
     * @param dateTime String类型时间（格式：yyyyMMddHHmmssSSS）
     * @return 返参
     * @author Shen Peihong
     */
    public static Date stringToDate(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(patternMillisOfNoSpace);
        try {
            return sdf.parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * LocalDate转String
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return 返参
     * @author Shen Peihong
     */
    public static String toStringOfLocalDate(@NonNull LocalDate date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd";
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern, Locale.CHINESE); //格式化对象
        return date.format(dtf);
    }
}