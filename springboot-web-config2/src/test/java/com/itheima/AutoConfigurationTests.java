package com.itheima;

import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * ClassName: AutoConfigurationTests
 * Description: 自动配置类原理测试
 *
 * @Author snuonuo
 * @Create 2023/11/25 14:15
 * @Version 1.0
 */
@SpringBootTest
public class AutoConfigurationTests {

    @Autowired
    private ApplicationContext applicationContext;
//    @Autowired
//    private Gson gson;
//    public void testIson(){
//        String json = gson.toJson(Result.success());
//        System.out.println(json);
//    }


    // 获取HeaderParser
    @Test
    public void testHeaderParser(){
        System.out.println(applicationContext.getBean(HeaderParser.class));
    }

    // 获取HeaderGenerator
    @Test
    public void HeaderGenerator(){
        System.out.println(applicationContext.getBean(HeaderGenerator.class));
    }

    // 获取TokenParser
    @Test
    public void TokenParser(){
        System.out.println(applicationContext.getBean(TokenParser.class));
    }



}
