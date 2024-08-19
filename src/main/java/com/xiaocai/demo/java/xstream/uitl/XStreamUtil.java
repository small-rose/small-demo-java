package com.xiaocai.demo.java.xstream.uitl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xiaocai.demo.java.xstream.bean.MsgBody;
import com.xiaocai.demo.java.xstream.bean.MsgHeader;
import com.xiaocai.demo.java.xstream.bean.XmlObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ XstreamUtil ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/15 13:40
 * @Version ： 1.0
 **/
public class XStreamUtil {

    private static Map<String, Class> xml2ObjectMap = new HashMap<>();

    static {
        xml2ObjectMap.put("message", XmlObject.class);
        xml2ObjectMap.put("head", MsgHeader.class);
        xml2ObjectMap.put("body", MsgBody.class);
    }

    private static XStream getXStream(Converter[] converter){
        XStream xstream = new XStream(new DomDriver("utf-8", new NoNameCoder()));
        xstream.autodetectAnnotations(true);
        for (Converter converter1 : converter) {
            xstream.registerConverter(converter1);
        }
        return xstream ;
    }

    public static String toXML(Object msgObj, Converter... converter){
        XStream xStream = getXStream(converter);
        return xStream.toXML(msgObj);
    }

    public static Object toObject(String xml, Converter... converter){
        XStream xStream = getXStream(converter);
        Map<String, Class> mapper = getXml2ObjectMap();
        Iterator<String> iterator = mapper.keySet().iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            xStream.alias(s, mapper.get(s));
            xStream.allowTypes((Class[]) Arrays.asList(mapper.get(s)).toArray());
        }
        //xStream.allowTypesByWildcard(new String[] { "com.xiaocai.demo.java.xstream.bean.**" });

        return  xStream.fromXML(xml);
    }

    public static  Map<String, Class> getXml2ObjectMap() {
        return xml2ObjectMap ;
    }

    public static   void putXml2ObjectMapper(String mapperKey, Class mapperClass) {
        xml2ObjectMap.put(mapperKey, mapperClass) ;
    }
}
