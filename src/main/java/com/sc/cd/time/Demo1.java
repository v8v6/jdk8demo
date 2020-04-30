package com.sc.cd.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.format.DateTimeFormat;

public class Demo1 {
    private static final String m = "yyyy-MM-dd HH:mm:ss";
    private static final String m1 = "yyyy-MM";

    public static void main(String[] args) {

        Date date = null;
        try {
            date = new SimpleDateFormat(m1).parse("2019-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        System.out.println(new SimpleDateFormat(m).format(calendar.getTime()));


        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        System.out.println(new SimpleDateFormat(m).format(calendar.getTime()));


        System.out.println("==================");
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime firstday = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastday = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        Date now = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(LocalDate.now().until(LocalDate.now().minusDays(5), ChronoUnit.MONTHS));
        Date date1 = DateTimeFormat.forPattern(m).parseDateTime("2020-02-01 00:00:00").toDate();
        Date date2 = DateTimeFormat.forPattern(m).parseDateTime("2020-02-01 00:00:00").toDate();
        Date date3 = DateTimeFormat.forPattern(m).parseDateTime("2020-01-31 23:59:59").toDate();
        System.out.println(date1.after(date2));
        System.out.println(date3.after(now));


        Date date4 = DateTimeFormat.forPattern(m).parseDateTime("2020-01-31 00:00:00").toDate();
        Period period2 = Period.between(localDateTime.toLocalDate(), date2LocalDateTime(date4).toLocalDate());
        period2.getYears();
        int months = period2.getMonths();
        System.out.println(months);
        long totalMonths = period2.toTotalMonths();
        System.out.println(totalMonths);


        System.out.println("-----------");

        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime localDateTime1 = now1.minusMonths(1);
        Date minTime = getFirstDay(localDateTime2Date(localDateTime1));
        System.out.println(new SimpleDateFormat(m).format(minTime));

        Date maxTime = getLastDay(localDateTime2Date(now1));
        System.out.println(new SimpleDateFormat(m).format(maxTime));

        System.out.println("-----------");

        Date date5 = string2Date("2020-02", m1);
        System.out.println(new SimpleDateFormat(m).format(date5));
        Date startTime = getFirstDay(date5);
        System.out.println(new SimpleDateFormat(m).format(startTime));
        System.out.println(startTime);
        Date endTime = getLastDay(date5);
        System.out.println(new SimpleDateFormat(m).format(endTime));
        System.out.println(endTime);
        System.out.println("===========");
        System.out.println(date5.before(minTime));
        System.out.println(date5.after(maxTime));
        System.out.println("-----------");

        System.out.println(startTime.getTime());
        System.out.println(minTime.getTime());
        System.out.println(startTime.getTime() == minTime.getTime());
        System.out.println(startTime.getTime() <= maxTime.getTime());


        System.out.println(Integer.valueOf("-001"));

        System.out.println("+++++++++++++++");
        calendar = Calendar.getInstance();
        Date date6 = DateTimeFormat.forPattern(m).parseDateTime("2020-12-31 00:00:00").toDate();
        calendar.setTime(date6);
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.YEAR));

        date6 = DateTimeFormat.forPattern(m).parseDateTime("2020-12-31 00:00:00").toDate();
        Date date7 = DateTimeFormat.forPattern(m).parseDateTime("2020-12-31 00:00:00").toDate();
        System.out.println(date6.before(date7));




    }


    public static Date getFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date localDate2Date(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static Date string2Date(String dateString, String pattern) {
        return DateTimeFormat.forPattern(pattern).parseDateTime(dateString).toDate();
    }
}
