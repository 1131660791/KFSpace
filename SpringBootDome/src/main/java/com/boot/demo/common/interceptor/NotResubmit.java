package com.boot.demo.common.interceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 防止重复提交
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface NotResubmit {
    /** * 时间 */
    int seconds();
    /** 提交次数 */
    int maxCount();
}