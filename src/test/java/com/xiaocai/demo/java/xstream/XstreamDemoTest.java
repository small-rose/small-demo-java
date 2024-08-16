package com.xiaocai.demo.java.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.JDom2Driver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.xiaocai.demo.java.xstream.bean.MsgBody;
import com.xiaocai.demo.java.xstream.bean.MsgHeader;
import com.xiaocai.demo.java.xstream.bean.Person;
import com.xiaocai.demo.java.xstream.bean.UserInfo;
import com.xiaocai.demo.java.xstream.bean.XmlObject;
import com.xiaocai.demo.java.xstream.uitl.XStreamUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ XstreamDemoTest ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/16 13:32
 * @Version ： 1.0
 **/
public class XstreamDemoTest {

    @Test
    public void toXml(){
        XmlObject xmlObject = new XmlObject();
        MsgHeader header = new MsgHeader();
        header.setTradeType("01");
        header.setTradeTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        header.setContentType("A1");
        header.setContentLength(3203);
        xmlObject.setHead(header);
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Jack");
        userInfo.setBirth("1997-09-09");
        userInfo.setLoginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));

        MsgBody body = new MsgBody(userInfo);
        xmlObject.setBody(body);

        String reqXml = XStreamUtil.toXML(xmlObject);
        System.out.println(reqXml);

        XStreamUtil.putXml2ObjectMapper("userInfo", UserInfo.class);
        XmlObject object = (XmlObject) XStreamUtil.toObject(reqXml);
        System.out.println(object);
    }



    @Test
    public void demoSimple() {
        Person bean = new Person("张三", 22, "1");
        XStream xstream = new XStream();
        //给 Perion 节点取别名
        xstream.alias("people", Person.class);
        // 将age 设置为 Persion 的属性
        xstream.useAttributeFor(Person.class, "age");
        //XML序列化
        String xml = xstream.toXML(bean);
        System.out.println(xml);
        //XML反序列化
        xstream.alias("people", Person.class);
        xstream.allowTypes(new Class[]{Person.class});
        bean = (Person) xstream.fromXML(xml);
        System.out.println(bean);
        xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        //Json序列化
        String json = xstream.toXML(bean);
        System.out.println(json);
        //Json反序列
        xstream.allowTypes(new Class[]{Person.class});
        xstream.setMode(XStream.NO_REFERENCES);
        bean = (Person) xstream.fromXML(json);
        System.out.println(bean);
    }

    @Test
    public void demoXmlTest01() {
        Person bean = new Person("张三", 22,"1");
        Xpp3Driver xpp3Driver =  new Xpp3Driver(new NoNameCoder());
        DomDriver domDriver = new DomDriver("utf-8",new NoNameCoder());
        JDom2Driver jDomDriver = new JDom2Driver(new NoNameCoder());
        StaxDriver staxDriver = new StaxDriver(new NoNameCoder());
         XStream xstream = new XStream(jDomDriver);
        //给 Perion 节点取别名
        xstream.alias("people", Person.class);
        // 将age 设置为 Persion 的属性
        xstream.useAttributeFor(Person.class, "age");
        // 将 name 节点名换成 user_name
        xstream.aliasField("user_name", Person.class, "name");
        xstream.aliasAttribute("status", "lockStatus");

        //XML序列化
        String xml = xstream.toXML(bean);
        System.out.println(xml);
        //XML反序列化
        xstream.alias("people", Person.class);
        xstream.allowTypes(new Class[]{Person.class});
        bean = (Person) xstream.fromXML(xml);
        System.out.println(bean);
    }

    @Test
    public void demoJsonTest01() {
        Person bean = new Person("张三", 22, "1");
        //JsonHierarchicalStreamDriver 这个类只能做json序列号，不能反序列化
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        //Json序列化
        String json = xstream.toXML(bean);
        System.out.println(json);

        xstream = new XStream(new JettisonMappedXmlDriver());
        //Json序列化
        String json2 = xstream.toXML(bean);
        System.out.println(json2);

        //Json反序列
        xstream.allowTypes(new Class[]{Person.class});
        bean = (Person) xstream.fromXML(json);
        System.out.println(bean);
    }
}
