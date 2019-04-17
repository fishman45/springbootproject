package com.aaron.utils;


import com.aaron.enums.LogEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lfl
 */
public class LogUtil {
    /**
     * 获取业务日志logger
     */
    public static Logger getBusinessLogger() {
        return LoggerFactory.getLogger(LogEnum.BUSSINESS.getCategory());
    }

    /**
     * 获取平台日志logger
     */
    public static Logger getPlatformLogger() {
        return LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
    }

    /**
     * 获取数据库日志logger
     */
    public static Logger getDbLogger() {
        return LoggerFactory.getLogger(LogEnum.DB.getCategory());
    }

    /**
     * 获取异常日志logger
     */
    public static Logger getExceptionLogger() {
        return LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
    }
}
