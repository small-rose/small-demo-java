package com.xiaocai.demo.java.concurrent.distsibution;

import com.xiaocai.demo.java.concurrent.distsibution.annotaion.DistributeConcurrencyLimit;
import com.xiaocai.demo.java.concurrent.distsibution.lock.DistributedLockManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.util.concurrent.TimeUnit;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ DistributionConcurrencyLimitAspect ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/11/21 15:28
 * @Version ： 1.0
 **/


//@Component
//@Aspect
public class DistributionConcurrencyLimitAspect {

    //@Autowired
    private DistributedLockManager lockManager;

    @Around("@annotation(distributeConcurrencyLimit)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint, DistributeConcurrencyLimit distributeConcurrencyLimit) throws Throwable {
        String methodName = joinPoint.getSignature().toLongString();
        int limit = distributeConcurrencyLimit.value();
        long timeout = distributeConcurrencyLimit.timeout();
        TimeUnit timeUnit = distributeConcurrencyLimit.timeUnit();
        //限制并发执行
        boolean acquired = lockManager.tryLock(methodName,limit,  timeout, timeUnit);
        if (acquired) {
            try {
                return joinPoint.proceed();
            } finally {
                lockManager.unlock(methodName);
            }
        } else {
            // 处理无法获取锁的情况
            throw new RuntimeException("Failed to acquire lock for method: " + methodName);
        }
    }
}
