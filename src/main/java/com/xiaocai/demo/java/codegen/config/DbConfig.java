package com.xiaocai.demo.java.codegen.config;


import com.xiaocai.demo.java.codegen.enums.DbType;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ DbConfig ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 17:30
 * @Version ： 1.0
 **/
@Data
public class DbConfig {


    private String type;
    private String driverName;
    private String url;
    private String userName;
    private String password;




    @NotNull
    public DbType getDbType() {
        return this.getDbType(this.url.toLowerCase());
    }

    @NotNull
    private DbType getDbType(@NotNull String str) {
        if (!str.contains(":mysql:") && !str.contains(":cobar:")) {
            if (str.contains(":oracle:")) {
                return DbType.ORACLE;
            } else if (str.contains(":postgresql:")) {
                return DbType.POSTGRE_SQL;
            } else if (str.contains(":sqlserver:")) {
                return DbType.SQL_SERVER;
            } else if (str.contains(":db2:")) {
                return DbType.DB2;
            } else if (str.contains(":mariadb:")) {
                return DbType.MARIADB;
            } else if (str.contains(":sqlite:")) {
                return DbType.SQLITE;
            } else if (str.contains(":h2:")) {
                return DbType.H2;
            } else if (!str.contains(":kingbase:") && !str.contains(":kingbase8:")) {
                if (str.contains(":dm:")) {
                    return DbType.DM;
                } else if (str.contains(":zenith:")) {
                    return DbType.GAUSS;
                } else if (str.contains(":oscar:")) {
                    return DbType.OSCAR;
                } else if (str.contains(":firebird:")) {
                    return DbType.FIREBIRD;
                } else if (str.contains(":xugu:")) {
                    return DbType.XU_GU;
                } else if (str.contains(":clickhouse:")) {
                    return DbType.CLICK_HOUSE;
                } else {
                    return str.contains(":sybase:") ? DbType.SYBASE : DbType.OTHER;
                }
            } else {
                return DbType.KINGBASE_ES;
            }
        } else {
            return DbType.MYSQL;
        }
    }
}
