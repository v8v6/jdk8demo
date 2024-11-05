package com.sc.cd.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Demo {
    public static void main(String[] args) {
        BigDecimal b1 = BigDecimal.valueOf(0).divide(BigDecimal.valueOf(340), 3, RoundingMode.HALF_UP);
        System.out.printf("b1:" + b1);
    }
}
