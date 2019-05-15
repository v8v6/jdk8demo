package com.sc.cd.date;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-30 14:28
 */
public class TimeUnitTest {
    public static void main(String[] args) {
        long seconds = TimeUnit.MINUTES.toMillis(5);
        System.out.println(seconds);
        seconds = TimeUnit.MILLISECONDS.toSeconds(5*60*1000);
        System.out.println(seconds);
        long convert = TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES);
        System.out.println(convert);
    }
}
