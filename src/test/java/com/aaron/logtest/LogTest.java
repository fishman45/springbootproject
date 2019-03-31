package com.aaron.logtest;

import com.aaron.utils.LogUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    @Test
    public void logTest() {
        Logger log = LogUtil.getExceptionLogger();
        Logger log1 = LogUtil.getBussinessLogger();
        Logger log2 = LogUtil.getDBLogger();

        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
    }
}
