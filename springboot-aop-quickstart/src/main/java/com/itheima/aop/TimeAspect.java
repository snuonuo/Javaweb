package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ClassName: TimeAspect
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/24 15:15
 * @Version 1.0
 */


@Slf4j
@Component
@Aspect // AOP类
public class TimeAspect {

    @Around("execution(* com.itheima.service.*.*(..))") // 切入点表达式
    public Object RecordTime(ProceedingJoinPoint joinPoint) throws Throwable {

        // 1· 记录开始时间
        long start=System.currentTimeMillis();

        // 2. 执行原始方法
        Object result = joinPoint.proceed();

        // 3. 记录结束时间，计算耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"执行方法耗时: {}ms", end-start);
        return result;

    }
}










