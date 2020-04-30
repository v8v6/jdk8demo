package com.sc.cd.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.joda.time.format.DateTimeFormat;

public class Demo3 {

    private static final String m = "yyyy-MM-dd HH:mm:ss";
    private static final String m1 = "yyyy-MM";

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int dayOfYear = localDateTime.getDayOfYear();
        int dayOfMonth = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("今天是" + localDateTime + "\n"
                + "本年当中第" + dayOfYear + "天" + "\n"
                + "本月当中第" + dayOfMonth + "天" + "\n"
                + "本周中星期" + dayOfWeek.getValue() + "-即" + dayOfWeek + "\n");

        int year = localDateTime.getYear();
        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println("今天是" + localDateTime + "\n"
                + "年 ： " + year + "\n"
                + "月 ： " + month.getValue() + "-即 "+ month + "\n"
                + "日 ： " + day + "\n"
                + "时 ： " + hour + "\n"
                + "分 ： " + minute + "\n"
                + "秒 ： " + second + "\n"
        );


        LocalDate localDate1 = LocalDate.of(2018, 8, 8);
        LocalDate localDate2 = LocalDate.of(2018, 8, 8);
        boolean date1IsBeforeDate2 = localDate1.isBefore(localDate2);
        System.out.println("date1IsBeforeDate2 : " + date1IsBeforeDate2);

        String strDate = "2015-08-04";
        LocalDate aLD = LocalDate.parse(strDate);
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MMM uuuu QQQQ");
        System.out.println(aLD + " formats as " + dTF.format(aLD));

        dTF = DateTimeFormatter.ofPattern("dd MMM uuuu");
        String anotherDate = "04 八月 2015";
        LocalDate lds = LocalDate.parse(anotherDate, dTF);
        System.out.println(anotherDate + " parses to " + lds);

        System.out.println("-------------");

        System.out.println(System.getenv());
        System.out.println(System.getProperties());


    }

    public static Date string2Date(String dateString, String pattern) {
        return DateTimeFormat.forPattern(pattern).parseDateTime(dateString).toDate();
    }
}
