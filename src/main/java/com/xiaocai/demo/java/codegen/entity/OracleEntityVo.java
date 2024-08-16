package com.xiaocai.demo.java.codegen.entity;

import lombok.Data;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ OracleEntityVo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 20:52
 * @Version ： 1.0
 **/

@Data
public class OracleEntityVo extends EntityVo{

    private String tableName ;
    private String columnName ;
    private String dataType ;
}
