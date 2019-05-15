package com.sc.cd.jdk8.stream.tomap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        Member member1 = new Member();
        member1.setId("id_1");
        member1.setImgPath("http://www.google.com");

        Member member2 = new Member();
        member2.setId("id_1");
        member2.setImgPath("http://www.baidu.com");

        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);

        Map<String, String> map = list.stream().collect(Collectors.toMap(Member::getId, Member::getImgPath, (oldValue, newValue) -> oldValue));
        System.out.println(map);
        map = list.stream().collect(Collectors.toMap(Member::getId, Member::getImgPath));
        System.out.println(map);



    }
}
