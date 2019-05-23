package com.aaron.utils;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author: lfl
 * @description:
 * @date: Create in 2019/5/23 下午 04:44
 */
@Component
public class EmailUtil {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private GroupTemplate groupTemplate;

    /**
     * @param from     发送方邮箱地址
     * @param authWord 授权码
     * @param to       接收方邮箱地址
     * @param subject
     * @param content
     * @description: 发送简单邮件
     */
    public void sendTextMessage(String from, String authWord, String to, String subject, String content) {
        // 设置发送人邮箱和授权码
        mailSender.setUsername(from);
        mailSender.setPassword(authWord);
        // 实例化消息对象
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(content);
        try {
            // 发送消息
            this.mailSender.send(msg);
            System.out.println("邮件发送成功");
        } catch (MailException e) {
            System.out.println("邮件发送失败:" + e.getMessage());
        }
    }

    /**
     * @param from     发送方邮箱地址
     * @param authWord 授权码
     * @param to       接收方邮箱地址
     * @param subject
     * @param content
     * @param files
     * @description: 发送带附件的邮件
     */
    public void sendEmailWithAttachments(String from, String authWord, String to, String subject,
                                         String content, Map<String, File> files) {
        try {
            // 设置发送人邮箱和授权码
            mailSender.setUsername(from);
            mailSender.setPassword(authWord);
            // 实例化消息对象
            MimeMessage message = mailSender.createMimeMessage();
            // 需要指定第二个参数为true 代表创建支持可选文本，内联元素和附件的多部分消息
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            // 传入附件
            for (Map.Entry<String, File> entry : files.entrySet()) {
                helper.addAttachment(entry.getKey(), entry.getValue());
            }
            // 发送消息
            this.mailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("邮件发送失败:" + e.getMessage());
        }
    }

    /**
     * @param from     发送方邮箱地址
     * @param authWord 授权码
     * @param to       接收方邮箱地址
     * @param subject
     * @param content
     * @param file
     * @description: 发送带内嵌资源的邮件
     */
    public void sendEmailWithInline(String from, String authWord, String to,
                                    String subject, String content, File file) {
        try {
            // 设置发送人邮箱和授权码
            mailSender.setUsername(from);
            mailSender.setPassword(authWord);
            // 实例化消息对象
            MimeMessage message = mailSender.createMimeMessage();
            // 需要指定第二个参数为true 代表创建支持可选文本，内联元素和附件的多部分消息
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            // 使用true标志来指示包含的文本是HTML 固定格式资源前缀 cid:
            helper.setText("<html><body><img src='cid:image'></body></html>", true);
            // 需要先指定文本 再指定资源文件
            FileSystemResource res = new FileSystemResource(file);
            helper.addInline("image", res);
            // 发送消息
            this.mailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("邮件发送失败:" + e.getMessage());
        }
    }

    /**
     * @param from     发送方邮箱地址
     * @param authWord 授权码
     * @param to       接收方邮箱地址
     * @param subject
     * @param content
     * @description: 使用模板邮件
     */
    public void sendEmailByTemplate(String from, String authWord, String to,
                                    String subject, String content) {
        try {
            Template t = groupTemplate.getTemplate("template.html");
            t.binding("subject", subject);
            t.binding("content", content);
            String text = t.render();
            // 设置发送人邮箱和授权码
            mailSender.setUsername(from);
            mailSender.setPassword(authWord);
            // 实例化消息对象
            MimeMessage message = mailSender.createMimeMessage();
            // 指定 utf-8 防止乱码
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            // 为true 时候 表示文本内容以 html 渲染
            helper.setText(text, true);
            this.mailSender.send(message);
            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            // 消息发送失败可以做对应的处理
            System.out.println("邮件发送失败:" + e.getMessage());
        }
    }
}
