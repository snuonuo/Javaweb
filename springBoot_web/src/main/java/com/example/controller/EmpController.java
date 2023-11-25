package com.example.controller;

import com.example.anno.Log;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 员工管理Controller
 */
@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue ="1") Integer page,
                       @RequestParam(defaultValue ="10") Integer pageSize,
                        String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {}, {}, {}, {}, {}, {}: ", page, pageSize, name, gender, begin, end);
        PageBean pagebean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pagebean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除员工, ids: {}: ", ids);
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工: {}: ", emp);
        empService.save(emp);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查询员工, id: {}: ", id);
        Emp emp=empService.selectById(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工数据为: {}: ", emp);
        empService.update(emp);
        return Result.success();
    }



}

