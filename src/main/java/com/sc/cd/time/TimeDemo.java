package com.sc.cd.time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.LocalDate;

public class TimeDemo {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate lastDayOfPreviousMonth = now.minusMonths(1).dayOfMonth().withMaximumValue();
        System.out.println(lastDayOfPreviousMonth);
        LocalDate firstDayOfCurrentMouth = now.dayOfMonth().withMinimumValue();
        System.out.println(firstDayOfCurrentMouth);
        LocalDate lastDayOfCurrentMouth = now.dayOfMonth().withMaximumValue();
        System.out.println(lastDayOfCurrentMouth);
        LocalDate firstDayOfNextMouth = now.plusMonths(1).dayOfMonth().withMinimumValue();
        System.out.println(firstDayOfNextMouth);


        System.out.println(firstDayOfCurrentMouth.toDate());
        System.out.println(lastDayOfCurrentMouth.toDate());
        System.out.println("----------------");


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date startTime = cal.getTime();
        System.out.println(startTime);
        System.out.println("+++++++++");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime minTime = localDateTime.with(LocalTime.MIN);
        LocalDateTime maxTime = localDateTime.with(LocalTime.MAX);
        System.out.println(minTime);
        System.out.println(maxTime);
        System.out.println("---------------");
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = maxTime.atZone(zoneId);
        Date from = Date.from(zonedDateTime.toInstant());
        System.out.println(from);
        ZonedDateTime dateTime = minTime.atZone(zoneId);
        Date date = Date.from(dateTime.toInstant());
        System.out.println(date);

    }
}
