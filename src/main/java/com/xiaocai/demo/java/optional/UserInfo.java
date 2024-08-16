package com.xiaocai.demo.java.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ UserVo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/8 9:23
 * @Version ： 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserInfo {

    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String vipLeveL;

}
