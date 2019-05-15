package com.sc.cd.date;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-11 23:15
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime arrivalDate = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at : %s %n", landing);
            format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            /*Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
            ZoneId zone = ZoneId.systemDefault();
            String crateTime = LocalDateTime.ofInstant(instant, zone).format(format);
            System.out.println(crateTime);*/

            Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
            Date date = Date.from(instant);
            System.out.println(date);
            Thread.sleep(5000);
            instant = Instant.ofEpochMilli(System.currentTimeMillis());
            date = Date.from(instant);
            System.out.println(date);


            Instant toInstant = date.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            String crateTime = LocalDateTime.ofInstant(toInstant, zone).format(format);
            System.out.println(crateTime);
        } catch (DateTimeException | InterruptedException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }
}
