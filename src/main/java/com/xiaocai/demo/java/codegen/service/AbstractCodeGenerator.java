package com.xiaocai.demo.java.codegen.service;

import com.xiaocai.demo.java.codegen.config.GenConfig;
import com.xiaocai.demo.java.codegen.dao.EntityDao;
import com.xiaocai.demo.java.codegen.entity.EntityVo;

import java.util.List;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ CodeGenService ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 11:25
 * @Version ： 1.0
 **/

public abstract class AbstractCodeGenerator implements Generator{

    protected GenConfig genConfig ;
    protected EntityDao entityDao ;
    protected List<EntityVo> entityVoList ;

    public AbstractCodeGenerator(GenConfig genConfig) {
        this.genConfig = genConfig;
    }

    @Override
    public void loadConfig(GenConfig genConfig) {
        this.genConfig = genConfig;
    }

    @Override
    public void queryMetaData() {
        entityVoList = entityDao.queryAll(genConfig);
    }


    @Override
    public List<EntityVo> getEntityData() {
        return entityVoList;
    }
}
