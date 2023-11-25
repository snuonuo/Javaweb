package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    @Bean
//    @ConditionalOnClass(name = "io.jsonwebtoken.Jwts") // 在有这个类的条件下才会将这个bean加入IOC容器中
//    @ConditionalOnMissingBean // 不存在这个类型的bean才会将该bean加入到IOC容器中 - 指定类型/名称
//    @ConditionalOnProperty(name = "name", havingValue = "itheima") // 配置文件中的属性和值，有对应的值才会将bean加入到IOC中
    public HeaderParser headerParser(){
        return new HeaderParser();
    }

    @Bean
    public HeaderGenerator headerGenerator(){
        return new HeaderGenerator();
    }
}
