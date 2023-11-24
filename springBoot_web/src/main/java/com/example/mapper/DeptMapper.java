package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    /*
    * 查询全部部门数据
    * */
    @Select("select * from dept")
    List<Dept> list();

    /*
     * 根据id删除数据
     * */
    @Delete("delete from dept where id=#{id}")
    void delete(Integer id);

    /*
     * 新增部门
     * */
    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /*
     * 修改id为给定Id的部门的名字为name
     * */
    @Update("update dept set name=#{name} where id=#{id}")
    void update(Integer id, String name);

}




















