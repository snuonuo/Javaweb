package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp selectById(Integer id);

    void update(Emp emp);

    /**
     * 实现员工登录操作的
     * */
    Emp login(Emp emp);
}
