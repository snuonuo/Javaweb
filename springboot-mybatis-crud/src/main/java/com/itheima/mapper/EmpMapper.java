package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    // 根据id删除数据
    // # 预编译
    // $ 不是预编译直接拼接
    @Delete("delete from emp where id=#{id}")
    public int delete(Integer id);
    // 新增员工
    // 主键返回
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    // 更新操作
    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, " +
            "job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);





// 根据id查询员工
//    @Select("select * from emp where id=#{id}")
//    public Emp selectById(Integer id);
// Emp(id=19, username=Tom1, password=123456, name=汤姆1, gender=1, image=1.jpg, job=1, entrydate=2000-01-01, deptId=null, createTime=null, updateTime=null)
// 后面的值没有封装进来 因为数据库字段和属性名不一致
// 方案一：给字段起别名，让别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
//    public Emp selectById(Integer id);
//   方案二：通过@Results，注解手动将映射封装
//    @Results({
//           @Result(column = "dept_id", property = "deptId"),
//           @Result(column = "create_time", property = "createTime"),
//           @Result(column = "update_time", property = "updateTime"),
//    })
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id, create_time, update_time from emp where id=#{id}")
//    public Emp selectById(Integer id);
// 方案三：开启mybatis驼峰命名的自动映射开关 a_column -> aColumn
// 在properties中开启
    @Select("select * from emp where id=#{id}")
    public Emp selectById(Integer id);

    // 条件查询
    // 使用了$拼接，会存在性能低，SQL注入等问题
//    @Select("select * from emp where name like '%${name}%' and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    // concat解决上述问题
//    @Select("select * from emp where name like concat('%', #{name}, '%') and gender = 1 " +
//            "and entrydate between '2010-01-01' and '2020-01-01' order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    // 动态条件查询 <if> <where>等mybatis标签
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    // 动态更新员工信息
    public void update2(Emp emp);

    // 批量删除员工
    public void deleteByIds(List<Integer> ids);
}
