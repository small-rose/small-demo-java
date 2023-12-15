package com.xiaocai.demo.java.stream;

import com.xiaocai.demo.java.stream.vo.IndexExpressions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ StreamDemo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/1/18 13:50
 * @Version ： 1.0
 **/

public class StreamDemo {


    @Test
    public void limit(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        List<Integer> collect = list.stream().filter(k ->  k > 3).limit(5).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }


    @Test
    public void MapDemo(){
        List<IndexExpressions> list = new ArrayList<>();

        list.add(new IndexExpressions("AMS_ABILITYPAY_REPORT_TD","AMS_ABILITYPAY_REPORT_01","MIRRORDATE ASC"));
        list.add(new IndexExpressions("AMS_ACCOUNTIMPDATA_TD","AMS_ACCOUNTIMPDATA_INDEX","ACCOUNTBATCHID ASC"));
        list.add(new IndexExpressions("AMS_ACCOUNTIMPDATA_TD","AMS_ACCOUNTIMPDATA_INDEX03","SYS_NC00022$ ASC,ACCOUNTNO ASC"));
        list.add(new IndexExpressions("AMS_AMORTIZEMODEL_TD","AMS_AMORTIZEMODE_PK","ID ASC"));
        list.add(new IndexExpressions("AMS_APPLICATIONS_SUCCESS","AMS_APPLICATIONS01","SUCCESSID ASC"));
        list.add(new IndexExpressions("AMS_APPLICATIONS_ERROR","AMS_APPLICATIONS_ERROR01","FAILEID ASC"));
        list.add(new IndexExpressions("AMS_APPLYTASK_TD","AMS_APPLYTASK_TD01","ID ASC"));
        list.add(new IndexExpressions("AMS_BAD_RULE_TD_OTHER","AMS_BAD_RULE_OTHER_PK","ID ASC"));
        list.add(new IndexExpressions("AMS_BAD_RULE_TD","AMS_BAD_RULE_PK","ID ASC"));
        list.add(new IndexExpressions("AMS_CONSUME_TD","AMS_CONSUME_TD01","TANO ASC"));

        Map<String, IndexExpressions> collect = list.stream().collect(Collectors.toMap(i -> i.getTableName(), (i) -> i));
        System.out.println(collect);

        Map<String, IndexExpressions> collect2 = list.stream().collect(Collectors.toMap(IndexExpressions::getTableName, (i) -> i));
        System.out.println(collect2);

        Map<String, IndexExpressions> collect3 = list.stream().collect(Collectors.toMap(IndexExpressions::getIndexName, (i) -> i));
        System.out.println(collect3);


        Map<String, IndexExpressions> collect4 = list.stream().collect(Collectors.toMap(IndexExpressions::getIndexName, Function.identity()));
        System.out.println(collect4);

        Map<String, IndexExpressions> collect5 = list.stream().collect(Collectors.toMap(IndexExpressions::getIndexName, Function.identity(), (k1,k2)->k2));
        System.out.println(collect5);

    }
}
