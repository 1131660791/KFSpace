package com.boot.demo.common.util.date;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * 全局时间常量
 */
public interface DateConstants {

    /**
     * 系统启动时间
     */
    Date SYSTEM_START_TIME = new Date();

    /**
     * 系统默认编码
     */
    String DEFAULT_CHAR_SET_VALUE = "UTF-8";
    Charset DEFAULT_CHAR_SET = Charset.forName(DEFAULT_CHAR_SET_VALUE);

    /**
     * 日期格式
     */
    String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 紧凑的日期格式
     */
    String COMPACT_DATE_FORMAT = "yyyyMMdd";

    /**
     * 日期时间格式
     */
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Token 在传递过程中(Session, Cookie, URL, Header 参数)的名字
     */
    String TOKEN_PARA_NAME = "token";

    /**
     * 调试标志
     */
    String PARA_DEBUG = "debug";

    /**
     * 时间戳差值的起点
     */
    long EPOCH_MILLI = LocalDate.of(2010, 1, 1)
            .atStartOfDay(ZoneOffset.ofHours(8)).toInstant()
            .toEpochMilli();
}