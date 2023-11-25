package com.itheima.config;

import com.itheima.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: CommonConfig
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/25 14:03
 * @Version 1.0
 */
@Configuration
public class CommonConfig {


    // 声明第三方bean
    @Bean // 将当前方法的返回值交给IOC容器管理，成为IOC容器的bean
            // 可以使用Bean注解的name或者value给bean起名字
            // 默认名字就是这个方法名
            // 加参数 可以注入
    public SAXReader saxReader(DeptService deptService){
        return new SAXReader();
    }
}
