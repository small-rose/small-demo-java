package com.xiaocai.demo.java.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ MsgBody ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/16 13:11
 * @Version ： 1.0
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@XStreamAlias("body")
public class MsgBody {

    private Object object ;
}
