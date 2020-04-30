package com.sc.cd.date;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.time.DateUtils;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-03 18:01
 */
public class DateDemoTest {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        try {
            Date parseDate = DateUtils.parseDate("2019-02-30 09:21:12", "yyyy-MM-dd HH:mm:ss");
            System.out.println(parseDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parseDate);
            System.out.println(calendar.get(Calendar.YEAR));
            System.out.println(calendar.get(Calendar.MONTH));
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println(calendar.get(Calendar.HOUR));
            String s = "2019-02-30 09:21:12";
            LocalDateTime localDateTime = LocalDateTime.parse(s, dtf);
            String format = localDateTime.format(dtf);
            System.out.println(format);
            System.out.println(Objects.equals(format, s));

            LocalDate localDate = LocalDate.parse("2019-12-10");
            //localDate = localDate.minusMonths(1);
            System.out.println(localDate);
            localDateTime.toLocalDate();

            localDateTime = LocalDateTime.now();
            LocalDateTime preLocalDate = localDateTime.minusMonths(1)
                    .with(TemporalAdjusters.firstDayOfMonth())
                    .withHour(0).withMinute(0).withSecond(0);
            String format1 = preLocalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime l = LocalDateTime.parse(format1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(l);
            // l = LocalDateTime.parse("2019-10-10 11:12:38", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime payTime = LocalDateTime.parse("2019-10-31 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(isAfter(payTime, localDateTime) || !isAfter(payTime, l));

            String str = "APPLICATION/OCTET-STREAM";
            System.out.println(str.toLowerCase());

            int i = 0;
            // System.out.println(i++);
            System.out.println(++i);
            System.out.println("1111/".split("/")[0]);
            //System.out.println("1111/".split("/")[1]);
            System.out.println("========");
            System.out.println("1111//".split("/").length);
            System.out.println("1111".split("/").length);
            System.out.println("========");
            System.out.println("1111//".split("/")[0]);
            System.out.println("1111//".split("/")[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAfter(LocalDateTime aTime, LocalDateTime bTime) {
        return aTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                - bTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() >= 0;
    }
}
