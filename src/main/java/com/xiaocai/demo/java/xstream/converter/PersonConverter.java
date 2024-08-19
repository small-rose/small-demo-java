package com.xiaocai.demo.java.xstream.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.xiaocai.demo.java.xstream.bean.Person;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ PersonConverter ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/19 19:53
 * @Version ： 1.0
 **/
public class PersonConverter implements Converter {


    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
        Person person = (Person) value;
        writer.startNode("姓名");
        writer.setValue(person.getName());
        writer.endNode();
        writer.startNode("年龄");
        writer.setValue(person.getAge()+"");
        writer.endNode();
        writer.startNode("转换器");
        writer.setValue("自定义的转换器");
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
        Person person = new Person();
        reader.moveDown();
        person.setName(reader.getValue());
        reader.moveUp();
        reader.moveDown();
        person.setAge(Integer.parseInt(reader.getValue()));
        reader.moveUp();
        return person;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Person.class);
    }
}
