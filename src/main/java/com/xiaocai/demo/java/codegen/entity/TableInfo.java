package com.xiaocai.demo.java.codegen.entity;

import com.xiaocai.demo.java.codegen.config.GenConfig;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ TableInfo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 20:43
 * @Version ： 1.0
 **/

@Data
public class TableInfo {

    private GenConfig genConfig;
    private final Set<String> importPackages = new TreeSet();
    private boolean convert;
    private String name;
    private String comment;
    private String entityName;
    private String mapperName;
    private String xmlName;
    private String serviceName;
    private String serviceImplName;
    private String controllerName;
    private final List<EntityVo> fields = new ArrayList();
    private boolean havePrimaryKey;
    private String fieldNames;


    public String getEntityName() {
        return name.concat("Entity");
    }

    public String getMapperName() {
        return mapperName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceImplName() {
        return serviceImplName;
    }

    public String getControllerName() {
        return controllerName;
    }
}
