package com.xiaocai.demo.java.idbatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ BatchIdService ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/11/7 10:15
 * @Version ： 1.0
 **/

public class BatchIdService {

    private List<Integer> batchIds = new CopyOnWriteArrayList<>();

    private AtomicInteger currentIndex = new AtomicInteger(0) ;

    private int batchSize = 10 ;

    public Integer getNextId(){
        checkList();
        return getId();
    }

    private synchronized  Integer getId(){
        Integer id = batchIds.get(currentIndex.get());
        currentIndex.getAndIncrement();
        return id;
    }

    private synchronized  void checkList(){
        if (batchIds.size()<=0 || currentIndex.getAndDecrement() >= batchIds.size()){
            batchIds.clear();
            batchIds.addAll(loadIds(batchSize));
            currentIndex.set(0);
        }
    }


    Random random = new Random();
    private Collection  loadIds(int batchSize) {
//        String sql = "SELECT SEQ_TEST_ID.nextval FROM dual CONNECT BY level <= "+batchSize;
//        List <Long> result = jdbcTemplate.queryForList(sql, Long.class);

        List<Integer> result = new ArrayList<>();
        while (result.size() <8){
            int num  = random.nextInt(100)+1;
            if (!result.contains(num)){
                result.add(num);
            }
        }
        return result;
    }
}
