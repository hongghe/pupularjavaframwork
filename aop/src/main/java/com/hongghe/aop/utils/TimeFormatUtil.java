package com.hongghe.aop.utils;

import org.joda.time.DateTime;

/**
 * @author: hongghe @date: 2019-01-13 16:08
 */
public class TimeFormatUtil {

    public static Long currentTimestamp() {
        DateTime dateTime = new DateTime();
        return dateTime.getMillis()/1000;
    }
}
