package com.boot.demo.common.constant;

import java.nio.charset.Charset;

/**
 * 常量
 */
public interface Constants {

    /**
     * 系统默认编码
     */
    String DEFAULT_CHAR_SET_VALUE = "UTF-8";
    Charset DEFAULT_CHAR_SET = Charset.forName(DEFAULT_CHAR_SET_VALUE);

}
