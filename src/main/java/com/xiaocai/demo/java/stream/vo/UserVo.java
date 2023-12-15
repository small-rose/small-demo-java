package com.xiaocai.demo.java.stream.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ UserVo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/11/16 12:01
 * @Version ： 1.0
 **/
@Data
public class UserVo {

    private long id ;
    /**
     * level
     */
    private String vipLeveL ;
    /**
     * 姓别
     */
    private String  gender  ;
    /**
     * 姓名
     */
    private String name ;
    /**
     * 年龄
     */
    private int age ;
    /**
     * 金额
     */
    private BigDecimal amount ;

}
