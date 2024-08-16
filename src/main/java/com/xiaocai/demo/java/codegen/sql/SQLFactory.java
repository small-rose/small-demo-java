package com.xiaocai.demo.java.codegen.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ SQLFactory ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 14:18
 * @Version ： 1.0
 **/
public class SQLFactory {

    private static final SQLFactory instance = new SQLFactory();


    private static final List<SQLProvider> allList = new ArrayList<>();

    static {
        allList.add(new MySQL());
        allList.add(new Oracle());
    }

    public static SQLFactory getInstance() {
        return instance;
    }

    public String getSQL(String type) {
        SQLProvider provider = allList.stream().filter(s -> s.getType().name().equalsIgnoreCase(type)).findFirst().get();
        return provider.getSQL();
    }

    enum SQLType {
        MYSQL, ORACLE;
    }

    interface SQLProvider {
        public SQLType getType();

        public String getSQL();
    }

    static class MySQL implements SQLProvider {

        @Override
        public SQLType getType() {
            return SQLType.MYSQL;
        }

        @Override
        public String getSQL() {
            return SQLUtils.MYSQL_SQL;
        }
    }

    static class Oracle implements SQLProvider {

        @Override
        public SQLType getType() {
            return SQLType.ORACLE;
        }

        @Override
        public String getSQL() {
            return SQLUtils.ORACLE_SQL;
        }
    }
}
