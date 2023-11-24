package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * ClassName: UploadController
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/11 19:19
 * @Version 1.0
 */

@RestController
@Slf4j
public class UploadController {

    @Autowired
    AliOSSUtils aliOSSUtils;
    // 本地存储文件
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传: {}, {}, {}", username, age, image);
//        // 存储到本地
//        String filename=image.getOriginalFilename();
//        // 构造唯一的文件名(不能重复)  -  UUID（通用唯一识别码） +  文件扩展名
//        int index = filename.lastIndexOf(".");
//        String extName = filename.substring(index);
//        String newFileName = UUID.randomUUID().toString()+extName;
//        log.info("新的文件名:{}", newFileName);
//        image.transferTo(new File("E:\\5JAVA\\3JavaWeb\\images\\"+newFileName));
//        return Result.success();
//    }


    @PostMapping("/upload")
    // 阿里云OSS
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}", image.getOriginalFilename());

        // 调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url为：{}", url);
         return Result.success(url);
    }
}
