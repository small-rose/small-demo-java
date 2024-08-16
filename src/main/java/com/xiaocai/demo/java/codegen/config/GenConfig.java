package com.xiaocai.demo.java.codegen.config;


import com.xiaocai.demo.java.codegen.enums.CodeType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ DbConfig ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 17:30
 * @Version ： 1.0
 **/
@Builder
@Data
public class GenConfig {


    private DbConfig dbConfig;

    private CodeType codeType ;

    private List<String> tableList ;

    private List<String> excludeTableList ;

}
