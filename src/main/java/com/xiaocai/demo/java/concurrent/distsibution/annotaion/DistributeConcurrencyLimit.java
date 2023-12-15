package com.xiaocai.demo.java.concurrent.distsibution.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author small-rose
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributeConcurrencyLimit {

    int value() default 1;

    long timeout() default 0;

    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
