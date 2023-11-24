package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /*
    * 查询总记录数
    * */
    @Select("select count(*) from emp")
    public Long count();

    /*
     * 分页查询
     * @param
     * */
//    @Select("select * from emp limit #{start}, #{pageSize}")

    public List<Emp> page(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /*
     * 删除员工信息
     * @param
     * */

    void delete(List<Integer> ids);

    /*
     * 新增员工
     * @param
     * */
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void save(Emp emp);

    /*
     * 根据id查询员工
     * @param
     * */
    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);


    /*
     * 更新员工数据
     * @param
     * */
    void update(Emp emp);

    /**
     * 根据用户名和密码查询用户
     * */
    @Select("select * from emp where username= #{username} and password=#{password}")
    Emp getByUsernameAndPasswowrd(Emp emp);


    /**
     * 根据部门id删除员工
     * */
    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);

}
