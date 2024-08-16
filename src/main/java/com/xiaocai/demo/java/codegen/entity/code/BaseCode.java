package com.xiaocai.demo.java.codegen.entity.code;

import lombok.Data;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ BaseCode ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/18 14:53
 * @Version ： 1.0
 **/

@Data
public class BaseCode {

    protected String entityName;
    protected String serviceName;
    protected String serviceImplName;
    protected String controllerName;
}
