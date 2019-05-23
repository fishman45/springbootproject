package com.aaron.logtest;

import com.aaron.utils.LogUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lfl
 * @description: 日志测试类
 * @date: Create in 2019/5/2 下午 01:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    @Test
    public void logTest() {
        Logger exceptionLogger = LogUtil.getExceptionLogger();
        Logger businessLogger = LogUtil.getBusinessLogger();
        Logger DbLogger = LogUtil.getDbLogger();

        exceptionLogger.error("getExceptionLogger===日志测试");
        businessLogger.info("getBusinessLogger===日志测试");
        DbLogger.debug("getDBLogger===日志测试");
    }
}
