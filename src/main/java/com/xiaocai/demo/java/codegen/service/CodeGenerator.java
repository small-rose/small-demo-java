package com.xiaocai.demo.java.codegen.service;

import com.xiaocai.demo.java.codegen.config.GenConfig;
import com.xiaocai.demo.java.codegen.entity.EntityVo;
import com.xiaocai.demo.java.codegen.enums.CodeType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ CodeGenService ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 11:25
 * @Version ： 1.0
 **/

public class CodeGenerator extends AbstractCodeGenerator{

    private GenConfig config ;

    public CodeGenerator(GenConfig config) {
        super(config);
        this.config = config;
        queryMetaData();
    }

    @Override
    public void generator() {
        List<EntityVo> entityVoList = getEntityData();
        Map<String, List<EntityVo>> collect = entityVoList.stream().collect(Collectors.groupingBy(EntityVo::getTableName));
        for (String tabName : collect.keySet()){

            List<EntityVo> entityList = collect.get(tabName);

            CodeType codeType = config.getCodeType();

        }
    }

}
