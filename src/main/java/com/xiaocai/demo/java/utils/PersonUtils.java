package com.xiaocai.demo.java.utils;

import java.util.Random;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ NameUtils ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/11/16 12:19
 * @Version ： 1.0
 **/
public class PersonUtils {

    private static final String[] surnames = {"张", "王", "李", "赵", "陈", "刘", "杨", "黄", "吴", "周", "徐", "孙", "马", "朱", "胡", "郭", "何", "高", "林", "郑", "谢"};
    private static final String[] givenNames = {"明", "红", "强", "丽", "勇", "芳", "军", "秀", "健", "娜", "怀", "尖", "施", "励", "带", "拴", "质", "生", "丽", "应", "年", "驹", "宠", "游", "荷", "鹰", "欠", "编", "购", "月", "熏", "昭", "汤", "栓", "孔", "淳", "草", "杰", "适"};

    private static final Random random = new Random();

    public static String randomChineseName() {
        String surname = getRandomElement(surnames);
        String givenName = getRandomElement(givenNames);
        return surname + givenName;
    }

    private static <T> T getRandomElement(T[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }

    public static int randomYoungAge() {
        return randomAge(18, 58);
    }

    public static int randomAge(int minAge, int maxAge) {
        Random random = new Random();
        return random.nextInt(maxAge - minAge + 1) + minAge;
    }

    public static double randomAmount4Bit() {
        return randomAmount(100.0, 1000.00, 2);
    }

    public static double randomAmount(double minAmount, double maxAmount, int decimalPlaces) {
        Random random = new Random();
        double randomValue = minAmount + (maxAmount - minAmount) * random.nextDouble();
        return roundToDecimalPlaces(randomValue, decimalPlaces);
    }

    private static double roundToDecimalPlaces(double value, int decimalPlaces) {
        double factor = Math.pow(10, decimalPlaces);
        return Math.round(value * factor) / factor;
    }

}
