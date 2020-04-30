package com.sc.cd.time;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateUtils;

public class DateTimeDemo {
    public static void main(String[] args) throws ParseException {
        LocalDate localDate = LocalDate.of(2014, 3, 18);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        Date date = new Date();
        long dataL = date.getTime();
        System.out.println(String.format("%1$ty-%1$tm-%1$td; %2$ty-%2$tm-%2$td%n", date, dataL));
        System.out.println(String.format("%1$tY-%1$tB-%1$td; %2$tY-%2$tb-%2$td%n", date, dataL));
        System.out.println(String
                .format("%1$s%2$tY%2$tm%2$td%3$04d", "YYY", new Date(), 12437));
        Byte a = (byte) 1;
        Byte b = (byte) 2;
        System.out.println(Byte.compare(a,b));

        Date parseDate = DateUtils.parseDate("0019-9", "yyyy-MM");
        //如收入月份小于等于当前月份-2个月，或晚于本月，则取消本次数据导入，并在异常数据中提示：收入月份错误
        localDate = LocalDate.now();
        LocalDate l = localDate.minusMonths(2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH));
        System.out.println(l.getYear() + l.getMonthValue());

        System.out.println("============");
        String pattern = "^[2-9]\\d{3}-[0|1][1-9]$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher("2019-02"); // 获取 matcher 对象
        System.out.println(m.find());

        String format = String.format("%1$tY%1$tm%1$td", new Date());
        System.out.println(format);

        System.out.println((byte) 0 == 0);
    }
}
