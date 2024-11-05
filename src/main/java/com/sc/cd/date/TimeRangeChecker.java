package com.sc.cd.date;

import java.time.LocalTime;

public class TimeRangeChecker {

    public static void main(String[] args) {
        // 配置时间范围
        LocalTime t1 = LocalTime.parse("10:00:00");
        LocalTime t2 = LocalTime.parse("16:00:00");

        // 测试数据
        checkTimeRange("09:00:01", "09:01:01", t1, t2);
        checkTimeRange("09:00:01", "10:01:01", t1, t2);
        checkTimeRange("10:00:01", "10:01:01", t1, t2);
        checkTimeRange("10:00:01", "17:01:01", t1, t2);
        checkTimeRange("17:00:01", "17:02:01", t1, t2);
        checkTimeRange("23:00:01", "01:02:01", t1, t2);
        checkTimeRange("23:00:01", "10:02:01", t1, t2);

        System.out.println("===========================");
        // 配置时间范围
        t1 = LocalTime.parse("23:00:00");
        t2 = LocalTime.parse("05:00:00");

        // 测试数据
        checkTimeRange("22:00:01", "22:01:01", t1, t2);
        checkTimeRange("22:00:01", "23:01:01", t1, t2);
        checkTimeRange("23:01:01", "23:55:01", t1, t2);
        checkTimeRange("23:55:01", "02:01:01", t1, t2);
        checkTimeRange("02:01:01", "03:02:01", t1, t2);
        checkTimeRange("03:01:01", "05:02:01", t1, t2);
        checkTimeRange("05:01:01", "05:02:01", t1, t2);
        checkTimeRange("22:01:01", "04:02:01", t1, t2);
    }

    private static void checkTimeRange(String startTimeStr, String endTimeStr, LocalTime t1, LocalTime t2) {
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);

        boolean isInRange = isWithinRange(startTime, endTime, t1, t2);
        System.out.println("startTime = " + startTimeStr + ", endTime = " + endTimeStr + " -> " + (isInRange ? "符合条件" : "不符合条件"));
    }

    private static boolean isWithinRange(LocalTime startTime, LocalTime endTime, LocalTime t1, LocalTime t2) {
        if (t1.compareTo(t2) < 0) {
            return !((startTime.compareTo(t2) > 0 || startTime.compareTo(t1) < 0)
                    && (endTime.compareTo(t2) > 0 || endTime.compareTo(t1) < 0));
        } else if (t1.compareTo(t2) > 0) {
            return !(startTime.compareTo(t2) > 0 && startTime.compareTo(t1) < 0
                    && endTime.compareTo(t2) > 0 && endTime.compareTo(t1) < 0);
        } else {
            return true;
        }
    }

}
