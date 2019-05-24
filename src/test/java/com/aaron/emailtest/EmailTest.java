package com.aaron.emailtest;

import com.aaron.utils.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/5/23 下午 05:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    private EmailUtil emailUtil;

    // 发送方邮箱地址
    private static final String from = "1289563709@qq.com";

    // 发送方邮箱地址对应的授权码
    private static final String authWord = "dyllkbtpfnthjfbb";

    // 接收方邮箱地址
    private static final String to = "361647454@qq.com";

    /**
     * 发送简单邮件
     */
    @Test
    public void sendMessage() {
        emailUtil.sendTextMessage(from, authWord, to, "发送简单邮件", "Hello Spring Email");
    }

    /**
     * 发送带附件的邮件
     */
    @Test
    public void sendEmailWithAttachments() {
        Map<String, File> fileMap = new HashMap<>();
        fileMap.put("image1.jpg", new File("E:\\Aaron\\picture\\附件1.png"));
        fileMap.put("image2.jpg", new File("E:\\Aaron\\picture\\附件2.png"));
        emailUtil.sendEmailWithAttachments(from, authWord, to, "发送带附件的邮件"
                , "Hello Spring Email", fileMap);
    }

    /**
     * 发送带内嵌资源的邮件
     */
    @Test
    public void sendEmailWithInline() {
        emailUtil.sendEmailWithInline(from, authWord, to, "发送带内嵌资源的邮件"
                , "Hello Spring Email", new File("E:\\Aaron\\picture\\附件3.png"));
    }

    /**
     * 使用模板邮件
     */
    @Test
    public void sendEmailByTemplate() {
        emailUtil.sendEmailByTemplate(from, authWord, to,
                "使用模板邮件", "Hello Spring Email");
    }
}
