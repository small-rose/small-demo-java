package com.xiaocai.demo.java.xstream.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.xiaocai.demo.java.xstream.bean.UserInfo;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ UserInfoConverter ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/19 19:39
 * @Version ： 1.0
 **/
public class UserInfoConverter implements Converter {


    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
        UserInfo userInfo = (UserInfo) o;
        writer.startNode("姓名");
        writer.setValue(userInfo.getName());
        writer.endNode();
        writer.startNode("生日");
        writer.setValue(userInfo.getBirth()+"");
        writer.endNode();
        writer.startNode("登录时间");
        writer.setValue(userInfo.getLoginTime()+"");
        writer.endNode();
        writer.startNode("转换器");
        writer.setValue("自定义的转换器");
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
        UserInfo userInfo = new UserInfo();
        reader.moveDown();
        userInfo.setName(reader.getValue());
        reader.moveUp();
        reader.moveDown();
        userInfo.setBirth(reader.getValue());
        reader.moveUp();
        reader.moveDown();
        userInfo.setLoginTime(reader.getValue());
        reader.moveUp();
        return userInfo;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(UserInfo.class);
    }
}
