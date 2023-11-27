package com.example.dao.impl;

import com.example.dao.EmpDao;
import com.example.pojo.Emp;
import com.example.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: EmpDao1
 * Description:
 * DAO层：
 * 负责数据访问操作
 * @Author snuonuo
 * @Create 2023/11/27 16:29
 * @Version 1.0
 */

@Component // 控制反转（IOC）
//@Repository 表示是数据访问层的bean

public class EmpDao1 implements EmpDao {

    public List<Emp> listEmp(){
        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }


}
