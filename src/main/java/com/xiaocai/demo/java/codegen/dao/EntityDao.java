package com.xiaocai.demo.java.codegen.dao;

import com.xiaocai.demo.java.codegen.config.DbConfig;
import com.xiaocai.demo.java.codegen.config.GenConfig;
import com.xiaocai.demo.java.codegen.entity.EntityVo;
import com.xiaocai.demo.java.codegen.sql.SQLFactory;
import com.xiaocai.demo.java.utils.DataSourceUtils;
import com.xiaocai.demo.java.utils.SmallUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ EntityDao ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 14:58
 * @Version ： 1.0
 **/
public class EntityDao {

    private JdbcTemplate jdbcTemplate ;


    public List<EntityVo> queryAll(GenConfig config){
        DbConfig dbConfig = config.getDbConfig();
        if (SmallUtils.isEmpty(jdbcTemplate)) {
            jdbcTemplate = new JdbcTemplate(DataSourceUtils.createDataSource(dbConfig));
        }

        List<String> tabList = config.getTableList();
        String sql = SQLFactory.getInstance().getSQL(dbConfig.getDbType().name());
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(EntityVo.class), tabList);
    }

}
