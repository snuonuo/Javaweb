package com.example.service;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    /*
    * 查询全部部门数据
    * */
    List<Dept> list();
    /*
     * 根据id删除数据
     * */
    void deleteById(Integer id);
    /*
     * 新增部门
     * */
    void add(Dept dept);

    void update(Integer id, String name);
}
