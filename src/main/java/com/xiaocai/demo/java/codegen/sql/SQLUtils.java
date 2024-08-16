package com.xiaocai.demo.java.codegen.sql;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ SQLUtils ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 14:57
 * @Version ： 1.0
 **/
public class SQLUtils {


    public static final String MYSQL_SQL = "SELECT t.TABLE_NAME, t.COLUMN_NAME, t.COLUMN_TYPE, t.CHARACTER_MAXIMUM_LENGTH, t.COLUMN_COMMENT\n" +
            "FROM INFORMATION_SCHEMA.COLUMNS t\n" +
            "WHERE TABLE_NAME in ( ? )";

    public static final String ORACLE_SQL =
            "SELECT T.TABLE_NAME, T.COLUMN_NAME, CASE  WHEN T.DATA_TYPE='DATE' THEN  T.DATA_TYPE\n" +
                    "            WHEN T.DATA_TYPE='NUMBER' THEN              ( CASE WHEN  T.DATA_PRECISION IS NOT NULL THEN\n" +
                    "                T.DATA_TYPE || '(' || T.DATA_PRECISION || ','|| T.DATA_SCALE ||')'\n" +
                    "                    ELSE T.DATA_TYPE END)            WHEN T.CHARACTER_SET_NAME IS NOT NULL THEN  T.DATA_TYPE ||'(' || T.CHAR_LENGTH || ')'\n" +
                    "            ELSE    T.DATA_TYPE || '(' || T.DATA_LENGTH || ')' END  DATA_TYPE, T.DATA_LENGTH, C.COMMENTS\n" +
                    "FROM USER_TAB_COLUMNS T JOIN USER_COL_COMMENTS C ON T.TABLE_NAME = C.TABLE_NAME AND T.COLUMN_NAME = C.COLUMN_NAME\n" +
                    "WHERE T.TABLE_NAME in ( ? )";
}
