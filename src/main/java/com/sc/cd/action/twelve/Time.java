package com.sc.cd.action.twelve;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalField;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-25 23:20
 */
public class Time {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2018, 12, 26);
        Month month = localDate.getMonth();
        System.out.println(month);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getEra());

        System.out.println("====================================================");

        localDate = LocalDate.parse("2014-03-18");
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getEra());
        System.out.println("====================================================");

        LocalTime localTime = LocalTime.of(13, 45, 20);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
    }
}
