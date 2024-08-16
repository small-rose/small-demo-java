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

public abstract class GeneratorContext {

    private EntityDao entityDao ;
    private EntityCodeService entityCodeService ;
    private GenConfig config ;
    private List<EntityVo> entityVoList ;

    public EntityDao getEntityDao() {
        return entityDao;
    }

    public abstract void setEntityDao(EntityDao entityDao);

    public abstract EntityCodeService getEntityCodeService() ;

    public abstract void setEntityCodeService(EntityCodeService entityCodeService) ;

    public abstract GenConfig getConfig() ;

    public abstract void setConfig(GenConfig config) ;

    public abstract List<EntityVo> getEntityVoList();

    public abstract void setEntityVoList(List<EntityVo> entityVoList);


}
