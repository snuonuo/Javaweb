package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testDelete(){
        // 返回值 是此次操作删除了多少条数据
        int delete=empMapper.delete(17);
        System.out.println(delete);
    }
    @Test
    public void testInsert(){
        Emp emp = new Emp();
        emp.setUsername("Tom3");
        emp.setName("汤姆3");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.update(emp);
    }

    @Test
    public void testSelectById(){
        // 返回值 是此次操作删除了多少条数据
        Emp emp=empMapper.selectById(19);
        System.out.println(emp);
    }

    @Test
    public void testList(){
        List<Emp> emp = new ArrayList<>();
//        emp = empMapper.list("张", (short)1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
//        emp = empMapper.list("张", null, null, null);
        // 下面这个会报错 s使用XML里的<where>关键字 就不会了
        emp = empMapper.list(null, (short)1, null, null);
        System.out.println(emp);
    }


    // 动态更新员工信息
    // 要更新的字段都固定死了，没有传递的话就会更新为null
    @Test
    public void testUpdate2(){
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Tom222");
        emp.setName("汤姆222");
        emp.setImage("1.jpg");
        emp.setGender((short)2);
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update2(emp);
    }

    // 测试批量删除方法
    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(13, 14, 15);
        empMapper.deleteByIds(ids);
    }
}
