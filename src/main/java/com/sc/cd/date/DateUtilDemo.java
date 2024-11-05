package com.sc.cd.date;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtilDemo {
    public static void main(String[] args) {
        long d1 = 1724313754000L;
        long d2 = 1724302954000L;
        Date dd1 = new Date(d1), dd2 = new Date(d2);
        long between = DateUtil.between(dd1, dd2, DateUnit.MINUTE);
        System.out.printf("s" + between);

        Duration startDuration = Duration.between(LocalDateTime.ofInstant(dd1.toInstant(),
                ZoneId.systemDefault()), LocalDateTime.ofInstant(dd2.toInstant(),
                ZoneId.systemDefault()));
        System.out.printf("startDuration" + startDuration.toMinutes());
    }
}
