package com.xiaocai.demo.java.codegen.service;

import com.xiaocai.demo.java.codegen.config.GenConfig;
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

public interface Generator {

    /**
     * 加载配置
     */
    void loadConfig(GenConfig genConfig);

    /**
     * 查询元数据
     * @return
     */
    void queryMetaData();

    /**
     * 生成代码
     */
    void generator();

    /**
     *
     * @return
     */
    List<EntityVo> getEntityData();
}
