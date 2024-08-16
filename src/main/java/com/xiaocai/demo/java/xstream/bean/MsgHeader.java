package com.xiaocai.demo.java.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ MsgHeader ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/16 13:10
 * @Version ： 1.0
 **/


@Data
@XStreamAlias("head")
public class MsgHeader {

    @XStreamAlias("trade_time")
    private String tradeTime ;

    @XStreamAlias("trade_type")
    private String tradeType ;

    @XStreamAlias("content_Length")
    private int contentLength ;

    @XStreamAlias("content_Type")
    private String contentType ;

    @XStreamAlias("request_Id")
    private String requestId ;


}
