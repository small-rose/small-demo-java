package com.xiaocai.demo.java.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

import java.io.Serializable;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ XmlObject ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/16 13:07
 * @Version ： 1.0
 **/

@Data
@XStreamAlias("message")
public class XmlObject implements Serializable {

    private static final long serialVerionUID = -41080087734545487L ;

    @XStreamAsAttribute
    private MsgHeader head ;
    @XStreamAsAttribute
    private MsgBody body ;
}
