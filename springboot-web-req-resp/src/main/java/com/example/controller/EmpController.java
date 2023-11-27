package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.service.impl.EmpService1;
import com.example.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller层：
 * 负责接收请求响应数据
 * */

@RestController
//@Controller 表示是controller层的bean
public class EmpController {

    @Autowired // 依赖注入（DI）
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){

        // 1. 2. 调用service层处理后的数据
        List<Emp> empList = empService.listEmp();

        //3. 响应数据
        return Result.success(empList);
    }

}
