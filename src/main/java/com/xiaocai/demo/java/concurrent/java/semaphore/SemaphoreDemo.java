package com.xiaocai.demo.java.concurrent.java.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ SemaphoreDemo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/11/22 10:01
 * @Version ： 1.0
 **/
public class SemaphoreDemo {

    Semaphore semaphore = new Semaphore(5);

    public void exec(){
        try {
            semaphore.tryAcquire();

            // do something
        }finally {
            semaphore.release();
        }
    }
}
