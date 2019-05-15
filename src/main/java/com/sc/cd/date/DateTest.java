package com.sc.cd.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-03 18:01
 */
public class DateTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);
        System.out.println(cal.getTime());


        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));
        System.out.println(tenDays);

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println(threeMinutes);
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year);

        LocalDateTime dateTime = date.withMinute(2);
        System.out.println(dateTime);


        LocalDate date1 = LocalDate.of(2018, 12, 18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
        System.out.println(date1);
        System.out.println(date3);
        System.out.println(date2);

        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(s3);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(s1);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s2);
        s2 = date.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s2);
        s2 = date.format(DateTimeFormatter.ISO_TIME);
        System.out.println(s2);
        s2 = date.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(s2);

    }
}
