package com.xiaocai.demo.java.stream;

import com.xiaocai.demo.java.stream.vo.IndexExpressions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void streamCreate(){
        // 从数组构建 Stream 流
        String[] nums = {"1", "2", "3", "4"};
        Stream<String> numStream = Arrays.stream(nums);

        // 从集合构建 Stream 流
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> numberStream = numbers.stream();

        // 从多个参数构建 Stream 流
        Stream<String> colorStream = Stream.of("red", "green", "blue");

        // 从一个数组构建 Stream 流
        Double[] scores = {98.5, 85.4, 76.3, 92.1};
        Stream<Double> scoreStream = Stream.of(scores);


        // 从文件构建 Stream 流
        Path path = Paths.get("demo_data.txt");
        try (Stream<String> lineStream = Files.lines(path)) {
            // 对每一行进行操作
            lineStream.forEach(System.out::println);

            // 简写
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 从 I/O 资源构建 Stream 流
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 从标准输入读取每一行
            Stream<String> inputStream = reader.lines();
            // 对每一行进行操作
            inputStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用 generate() 方法构建 Stream 流, 生成一个随机数的 Stream 流
        Stream<Double> randomStream = Stream.generate(Math::random);
        // 限制 Stream 流的大小为 10
        randomStream.limit(10).forEach(System.out::println);

        // 使用 iterate() 方法构建 Stream 流
        // 生成一个斐波那契数列的 Stream 流
        Stream<Integer> fibonacciStream = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .map(t -> t[0]);
        // 限制 Stream 流的大小为 10
        fibonacciStream.limit(10).forEach(System.out::println);
    }

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
