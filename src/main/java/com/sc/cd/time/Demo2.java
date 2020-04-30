package com.sc.cd.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.joda.time.format.DateTimeFormat;

import com.sc.cd.util.DateTimeUtil;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

public class Demo2 {

    private static final String m = "yyyy-MM-dd HH:mm:ss";
    private static final String m1 = "yyyy-MM";

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime preLocalDateTIme = now.minusMonths(1);

        LocalDateTime localDateTime = preLocalDateTIme.with(ChronoField.DAY_OF_MONTH, 1)
                .with(ChronoField.HOUR_OF_DAY, 0)
                .with(ChronoField.MINUTE_OF_HOUR, 0)
                .with(ChronoField.SECOND_OF_MINUTE, 0)
                .with(ChronoField.MILLI_OF_SECOND, 0);
        System.out.println(new SimpleDateFormat(m).format(DateTimeUtil.localDateTime2Date(localDateTime)));
        System.out.println("----------");

        Date date = DateTimeFormat.forPattern(m).parseDateTime("2019-12-30 00:00:00").toDate();
        Date minTime = getFirstDay(DateTimeUtil.localDateTime2Date(preLocalDateTIme));
        System.out.println(new SimpleDateFormat(m).format(minTime));
        Date maxTime = getLastDay(DateTimeUtil.localDateTime2Date(now));
        System.out.println(new SimpleDateFormat(m).format(maxTime));
        System.out.println("---------------------");

        System.out.println(date.before(minTime) || date.after(maxTime));

        Date minDate1 = DateTimeFormat.forPattern(m).parseDateTime("2019-12-01 00:00:00").toDate();
        Date maxDate1 = DateTimeFormat.forPattern(m).parseDateTime("2020-01-31 00:00:00").toDate();
        Date minTime1 = getFirstDay(minDate1);
        Date maxTime1 = getLastDay(maxDate1);
        System.out.println(date.before(minTime1) || date.after(maxTime1));
        System.out.println("================");

        Date date1 = DateTimeFormat.forPattern(m1).parseDateTime("2019-12").toDate();
        System.out.println(new SimpleDateFormat(m).format(date1));
        System.out.println(date1.before(minTime1) || date1.after(maxTime1));


        System.out.println("===============");
        LocalDateTime localDateTime1 = preLocalDateTIme.with(ChronoField.DAY_OF_MONTH, 1)
                .with(ChronoField.HOUR_OF_DAY, 23)
                .with(ChronoField.MINUTE_OF_HOUR, 59)
                .with(ChronoField.SECOND_OF_MINUTE, 59)
                .with(ChronoField.MILLI_OF_SECOND, 0);
        System.out.println(new SimpleDateFormat(m).format(DateTimeUtil.localDateTime2Date(localDateTime1)));

        LocalDate localDate1 = LocalDate.now().with(firstDayOfYear());


        System.out.println("----------");
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(System.currentTimeMillis());

        System.out.println(Objects.equals("1", new String("1")));

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
}
