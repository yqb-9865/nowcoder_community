package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {

    //将第三方的Bean对象加入IoC容器
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        //返回的对象将被装配到容器内
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
