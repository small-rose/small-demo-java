package com.xiaocai.demo.java.stream.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ IndexExpressions ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/1/18 14:03
 * @Version ： 1.0
 **/
@AllArgsConstructor
@Data
public class IndexExpressions {

    private String tableName ;
    private String indexName ;
    private String columnName ;
}
