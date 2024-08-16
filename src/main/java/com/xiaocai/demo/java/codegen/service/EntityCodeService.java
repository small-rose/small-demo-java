package com.xiaocai.demo.java.codegen.service;

import com.xiaocai.demo.java.codegen.config.ConstVal;
import com.xiaocai.demo.java.codegen.config.GenConfig;
import com.xiaocai.demo.java.codegen.entity.EntityVo;
import com.xiaocai.demo.java.utils.CamelCaseUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ EntityCoodeService ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 20:59
 * @Version ： 1.0
 **/
@Service
public class EntityCodeService {



    public void genCode(GenConfig config, String tabName, List<EntityVo> entityList) {
        String entityName = CamelCaseUtils.toCamelCase(tabName);
        StringBuffer sb = new StringBuffer();

        StringBuffer sb1 = new StringBuffer();
        sb.append(sb1);
        sb.append("public class ").append(entityName).append(" {").append(ConstVal.Enter);

        entityList.forEach(e->{
            sb.append(ConstVal.Tab).append(e.getDataType());
        });
    }
}
