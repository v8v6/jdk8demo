package com.sc.cd.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class DateTimeUtil {

  public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
  public static final String DEFAULT_SHORT_PATTERN = "yyyy-MM-dd";

  public static String date2String(Date date, String pattern) {
    return new DateTime(date).toString(pattern);
  }

  public static String date2String(Date date) {
    if (Objects.isNull(date)) {
      return null;
    }
    return new DateTime(date).toString(DEFAULT_PATTERN);
  }

  public static String date2ShortString(Date date) {
    return new DateTime(date).toString(DEFAULT_SHORT_PATTERN);
  }

  public static Date string2Date(String dateString, String pattern) {
    return DateTimeFormat.forPattern(pattern).parseDateTime(dateString).toDate();
  }

  public static Date string2Date(String dateString) {
    return DateTimeFormat.forPattern(DEFAULT_PATTERN).parseDateTime(dateString).toDate();
  }

  /**
   * 计算两个日期相隔天数
   */
  public static long diffDay(Date startDate, Date endDate) {
    LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    long days =
        (localDate2Date(end).getTime() - localDate2Date(start).getTime()) / (24 * 60 * 60 * 1000);
    return days > 0 ? days : days * -1;
  }

  public static Date localDate2Date(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  public static Date localDateTime2Date(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }

  public static void main(String[] args) {
    System.out.println(getLastMonthValue());
  }

  public static int diffMin(Date startDate, Date endDate) {
    return (int) Math.ceil((endDate.getTime() / 1000 - startDate.getTime() / 1000) / (60d));
  }

  public static int diffHour(Date startDate, Date endDate) {
    return (int) Math.ceil((endDate.getTime() / 1000 - startDate.getTime() / 1000) / (60 * 60));
  }

  public static String getNowYearValue() {
    return String.valueOf(LocalDateTime.now().getYear());
  }

  public static String getNowMonthValue() {
    String value = String.valueOf(LocalDateTime.now().getMonthValue());
    if (value.length() == 1) {
      value = "0" + value;
    }
    return value;
  }

  public static String getLastYearValue() {
    LocalDate date = LocalDate.now().minusMonths(1);
    return String.valueOf(date.getYear());
  }

  public static String getLastMonthValue() {
    LocalDate date = LocalDate.now().minusMonths(1);
    String value = String.valueOf(date.getMonthValue());
    if (value.length() == 1) {
      value = "0" + value;
    }
    return value;
  }

  public static int getNowDayValue() {
    return LocalDateTime.now().getDayOfMonth();
  }

  public static LocalDateTime date2LocalDateTime(Date date) {
    Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
    ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
    return instant.atZone(zoneId).toLocalDateTime();
  }

  public static Date getLastMonthFirstDay() {
    LocalDate date = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
    return localDate2Date(date);
  }

  public static Date getLastMonthLastDay() {
    LocalDate date = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
    return localDate2Date(date);
  }

  public static Date getNowMonthFirstDay() {
    LocalDate date = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    return localDate2Date(date);
  }

  public static Date getNextMonthFirstDay() {
    LocalDate date = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
    return localDate2Date(date);
  }

  public static Date getNowMonthFirstDayBySetting(int year, int month) {
    return localDate2Date(LocalDate.of(year, month, 10).with(TemporalAdjusters.firstDayOfMonth()));
  }

  public static Date getNextMonthFirstDayBySetting(int year, int month) {
    return localDate2Date(LocalDate.of(year, month, 10).with(TemporalAdjusters.firstDayOfNextMonth()));
  }

  public static boolean isAfter(LocalDateTime aTime, LocalDateTime bTime) {
    return aTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        - bTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() >= 0;
  }
}
