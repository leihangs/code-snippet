package com.code.dubbo.common;

import java.util.Date;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-17 14:35
 * @description: 简单流水号生成器
 */

public class TrackBuilder {

    public static final String GLOBAL_TAG = "G";
    public static final String REQUESET_TAG = "R";
    public static final String INNER_REQUESET_TAG = "I";
    public static final String ANSWER_TAG = "A";

    public static String createGlobalId() {
        return new StringBuilder(GLOBAL_TAG).append(new Date().getTime()).toString();
    }

    public static String createRequestId() {
        return new StringBuilder(REQUESET_TAG).append(new Date().getTime()).toString();
    }

    public static String createInnerRequestId() {
        return new StringBuilder(INNER_REQUESET_TAG).append(new Date().getTime()).toString();
    }

    public static String createAnswerId() {
        return new StringBuilder(ANSWER_TAG).append(new Date().getTime()).toString();
    }
}
