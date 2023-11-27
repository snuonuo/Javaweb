package com.example.service.impl;

import com.example.dao.EmpDao;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

//@Component
//如果有不同的实现类，想要使用哪个实现类，就在它上面加上@Component，其他的实现类不要加这个注解
    // 注释掉了就不会被放到容器中管理
public class EmpService2 implements EmpService {

//    @Autowired // 依赖注入（DI）
    private EmpDao empDao;

    public List<Emp> listEmp() {

        // 1. 调用DAO获取数据
        List<Emp> empList=empDao.listEmp();

        //2. 对数据进行转换处理 - gender, job

        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男士");
            }else if("2".equals(gender)){
                emp.setGender("女士");
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
