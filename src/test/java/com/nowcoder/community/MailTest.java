package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    //发送一串字符串
    @Test
    public void testTextMail(){
        mailClient.sendMail("1026136841@qq.com", "测试", "测试一下");
    }

    //发送html
    @Test
    public void testHtmlMail(){
        //创建thymeleaf的context，存放数据
        Context context = new Context();
        context.setVariable("username", "sunday");
        //用引擎生成html字符串
        String process = templateEngine.process("/mail/demo", context);
        mailClient.sendMail("1026136841@qq.com", "html", process);
    }
}
