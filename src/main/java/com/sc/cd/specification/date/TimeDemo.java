package com.sc.cd.specification.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述:
 * 测试jdk8时间api
 *
 * @author junxi.chen
 * @create 2018-11-30 17:04
 */
public class TimeDemo {
    public static void main(String[] args) {
        Instant date = Instant.now();
        System.out.println(date.toString());
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(""+localDateTime.getMonth());
        //TODO: junxi.chen 2018-11-30 17:04 明日写数据接口
        //FIXME: junxi.chen 2018-11-30 逻辑错误，需要重新设计业务逻辑

        /// 代码暂时屏蔽,后期需要打开
        //if (true)
    }
}
