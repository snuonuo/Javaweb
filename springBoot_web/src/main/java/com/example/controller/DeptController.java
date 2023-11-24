package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
// 提供日志记录功能
@Slf4j
@RestController
// 将公共路径抽取到类上 就不用重复写了
@RequestMapping("/depts")
public class DeptController {

    // 使用框架记录日志
    // private static Logger log = LoggerFactory.getLogger(DeptController.class);
    // 不用谢这句代码 直接使用注解来完成 可以再别的代码里也是用不用重复写

    @Autowired
    private DeptService deptService;

   // @RequestMapping(value = "/depts", method = RequestMethod.GET) // 指定请求方式为get 限定请求方式
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门数据: {}",id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门数据: {}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门 {}: ", dept);
        deptService.update(dept.getId(), dept.getName());
        return Result.success();
    }


}
