package com.example.exception;

import com.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: GlobalExceptionHandeler
 * Description: 全局异常处理器
 *
 * @Author snuonuo
 * @Create 2023/11/23 17:40
 * @Version 1.0
 */
@RestController
public class GlobalExceptionHandeler {

    @ExceptionHandler(Exception.class) // 捕获了所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }


}
