package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


//@ComponentScan({"com.example", "com.itheima"})
//@Import({TokenParser.class, HeaderConfig.class, MyImportSelector.class}) // 可以导入 普通类、配置类、ImportSelector接口的实现类
// 第三方依赖自己封装好了EnableXXX，可以直接使用
@EnableHeaderConfig // 相当于@import对应的bean

@SpringBootApplication
public class SpringbootWebConfig2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfig2Application.class, args);
    }

}
