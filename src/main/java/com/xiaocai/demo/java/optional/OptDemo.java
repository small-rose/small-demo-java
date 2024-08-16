package com.xiaocai.demo.java.optional;

import java.util.Optional;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ OptDemo ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/8 9:22
 * @Version ： 1.0
 **/
public class OptDemo {

    public void optionalbuilderDemo() {
        // 构建一个value为null的optional对象；
        Optional<UserInfo> userInfoEmptyOpt = Optional.empty();

        // 构建一个value不可以为null的optional对象，如果of()的入参为null会报空指针异常；
        Optional<UserInfo> userInfoOpt = Optional.of(new UserInfo("小菜","123456", 18, "man","A"));

        // 构建一个value可以为null的optional对象；
        Optional<UserInfo> userInfoNullOpt = Optional.ofNullable(null);

        System.out.println(userInfoEmptyOpt);
        System.out.println(userInfoOpt);
        System.out.println(userInfoNullOpt);
//        输出如下：
//        Optional.empty
//        Optional[UserInfo(username=阿飞, password=123456, age=15, gender=man)]
//        Optional.empty

    }

    public void optionalGetDemo() {

        Optional<UserInfo> userInfoEmptyOpt = Optional.empty();
        Optional<UserInfo> userInfoOpt = Optional.of(new UserInfo("小菜1","123456", 19, "man","A"));

        // 直接获取，注意如果value==null，会报NoSuchElementException异常
        UserInfo userInfo1 = userInfoOpt.get();
        // orElse可以传入一个UserInfo类型的对象作为默认值;当value!=null时，返回value值；当value==null时，返回默认值作为代替；
        UserInfo userInfo2 = userInfoEmptyOpt.orElse(new UserInfo("小菜2","123456", 20, "男","A"));
        // orElseGet和orElse不同的是orElseGet可以传入一段lambda表达式；当value!=null时，返回value值；当value==null时，使用该lambda返回的对象作为默认值；
        UserInfo userInfo3 = userInfoEmptyOpt.orElseGet(() -> new UserInfo("小菜","123456", 21, "男","A"));
        // orElseThrow可以传入一段lambda表达式，lambda返回一个Exception；当value!=null时，返回value值；当value==null时，抛出该异常；
        UserInfo userInfo4 = userInfoOpt.orElseThrow(NullPointerException::new);

        System.out.println(userInfo1);
        System.out.println(userInfo2);
        System.out.println(userInfo3);
        System.out.println(userInfo4);

        // 输出如下：
        // UserInfo(username=小菜1, password=123456, age=19, gender=man, vipLevel=A)
        // UserInfo(username=小菜2, password=123456, age=20, gender=男, vipLevel=A)
        // UserInfo(username=小菜3, password=123456, age=21, gender=男, vipLevel=A)
        // UserInfo(username=小菜1, password=123456, age=19, gender=man, vipLevel=A)
    }

    public void OptionalToMapDemo() {

        Optional<UserInfo> userInfoOpt = Optional.of(new UserInfo("小菜", "123456", 15, "man","A"));

        // 原来value的类型是UserInfo，经过map转换为Optional<String>
        Optional<String> username = userInfoOpt.map(UserInfo::getUsername);

        // 当map的入参也是一个Optional时，经过map转化后会形成Optional<Optional<String>>这种嵌套结构；但flatMap可以把这种嵌套结构打平；
        Optional<Optional<String>> unFlatMap = userInfoOpt.map(user -> Optional.of(user.getUsername()));
        Optional<String> flatMap = userInfoOpt.flatMap(user -> Optional.of(user.getUsername()));

        System.out.println(username);
        System.out.println(unFlatMap);
        System.out.println(flatMap);

        // 输出如下：
        // Optional[阿飞]
        // Optional[Optional[阿飞]]
        // Optional[阿飞]

    }


    public void optionalPredicateDemo() {
        Optional<UserInfo> userInfoEmptyOpt = Optional.empty();
        Optional<UserInfo> userInfoOpt = Optional.of(new UserInfo("阿飞", "123456", 15, "man", "A"));

        // filter传入一个lambda，lambda返回值为boolean；true:不做任何改变，false:返回一个空的optional；
        Optional<UserInfo> userInfo = userInfoOpt.filter(user -> "错误的密码".equals(user.getPassword()));
        System.out.println(userInfo);

        // isPresent就是判断value是不是null；我们在调用get之前，一定要先调用isPresent，因为直接如果value是null，直接调用get会报异常；
        if (userInfoEmptyOpt.isPresent()) {
            UserInfo value = userInfoEmptyOpt.get();
            System.out.println("optional value:" + value);
        } else {
            System.out.println("optional value==null");
        }

        // ifPresent传入一段lambda，当value!=null时，执行里面的逻辑；当当value==null时，啥都不干；
        userInfoOpt.ifPresent(value -> System.out.println("optional value:" + value));

        // 输入如下：
        // Optional.empty
        // optional value==null
        // optional value:UserInfo(username=阿飞, password=123456, age=15, gender=man)
    }

}
