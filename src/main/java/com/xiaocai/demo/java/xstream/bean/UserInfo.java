package com.xiaocai.demo.java.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ UserInfo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/16 13:51
 * @Version ： 1.0
 **/

@Data
@XStreamAlias("userInfo")
public class UserInfo {

    @XStreamAlias("name")
    private String name ;

    @XStreamAlias("birth")
    private String birth ;

    @XStreamAlias("login_Time")
    private String loginTime;

}
