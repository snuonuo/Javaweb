package com.example.service.impl;

import com.example.dao.EmpDao;
import com.example.dao.impl.EmpDao1;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: EmpService1
 * Description:
 * Service层：
 * 负责业务逻辑处理
 * @Author snuonuo
 * @Create 2023/11/27 16:30
 * @Version 1.0
 */

@Component // 控制反转（IOC）
//@ComponentScan 扫描bean范围，默认是所在类的包及其子包，可以自己配置
//@Service 表示是Service层的bean
//如果有不同的实现类，想要使用哪个实现类，就在它上面加上@Component，其他的实现类不要加这个注解
public class EmpService1 implements EmpService {

    @Autowired // 依赖注入（DI）
    // 按照类型装配的！！
    // 如果容器中有多个同类型的bean：会报错
    // @Primary 使得同类型的某个指定类生效
//    @Qualifier(value = "指定bean的名字指定哪个bean生效")，在@Autowired之前使用
//    @Resource(name = "指定bean的名字") 单独使用来注入bean，JDK提供的，不是springboot框架里的注解

    private EmpDao empDao;

    public List<Emp> listEmp() {

        // 1. 调用DAO获取数据
        List<Emp> empList=empDao.listEmp();

        //2. 对数据进行转换处理 - gender, job

        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }




}
