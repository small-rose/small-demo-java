package com.xiaocai.demo.java.concurrent.stantalone.aop;

import com.xiaocai.demo.java.concurrent.stantalone.anntotion.ConcurrencyLimit;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ ConcurrencyLimitAop ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/11/21 15:17
 * @Version ： 1.0
 **/


@Component
@Aspect
public class ConcurrencyLimitAop {

    private final Map<String, Semaphore> methodSemaphoreMap = new ConcurrentHashMap<>();

    @Pointcut("@annotation(concurrencyLimit)")
    public void point(ConcurrencyLimit concurrencyLimit) {
    }

    @Before("point(concurrencyLimit)")
    public void beforeMethod(ConcurrencyLimit concurrencyLimit) throws InterruptedException {
        Semaphore semaphore = methodSemaphoreMap.computeIfAbsent(getMethodSignature(), key -> new Semaphore(concurrencyLimit.value()));
        semaphore.acquire();
    }

    @AfterReturning("point(concurrencyLimit)")
    public void afterMethod(ConcurrencyLimit concurrencyLimit) {
        Semaphore semaphore = methodSemaphoreMap.get(getMethodSignature());
        if (semaphore != null) {
            semaphore.release();
        }
    }

    private String getMethodSignature() {
        // 获取当前方法的签名，可以根据实际情况进行实现
        // 这里使用简单的方法名作为签名示例
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
}
