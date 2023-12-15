package com.xiaocai.demo.java.concurrent.distsibution.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ DistributedLockManager ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/11/21 15:20
 * @Version ： 1.0
 **/

@Component
public class DistributedLockManager {

    private final ConcurrentHashMap<String, RLock> locks = new ConcurrentHashMap<>();

    @Autowired
    private RedissonClient redissonClient;

    public boolean tryLock(String methodName, int limit, long timeout, TimeUnit timeUnit) throws InterruptedException {
        RLock lock = redissonClient.getLock(methodName);
        // 尝试在超时时间内获取锁
        boolean acquired = lock.tryLock(0, timeout, timeUnit);
        if (acquired) {
            // 检查当前的锁数量是否超过并发限制的数量, 如果超过了并发数就释放锁
            if (locks.values().stream().filter(RLock::isHeldByCurrentThread).count() > limit) {
                lock.unlock();
                return false;
            }

            locks.put(methodName, lock);
        }
        return acquired;
    }

    public void unlock(String methodName) {
        RLock lock = locks.remove(methodName);
        if (lock != null && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}
