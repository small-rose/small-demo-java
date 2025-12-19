package com.xiaocai.demo.java.util;


import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void split(){
        String  str = "3010100";
        String[] split = str.split(",");
        System.out.println(split);


    }

}
