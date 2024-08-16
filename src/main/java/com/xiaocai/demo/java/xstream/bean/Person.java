package com.xiaocai.demo.java.xstream.bean;

import lombok.Data;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ Person ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/16 15:04
 * @Version ： 1.0
 **/

@Data
public class Person {

    private String name;
    private int age;
    private String lockStatus;
    public Person(String name, int age, String lockStatus)
    {
        this.name=name;
        this.age=age;
        this.lockStatus = lockStatus ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lockStatus='" + lockStatus + '\'' +
                '}';
    }
}
