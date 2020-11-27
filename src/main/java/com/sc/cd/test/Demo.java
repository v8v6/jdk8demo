package com.sc.cd.test;

import java.math.BigDecimal;
import java.util.Objects;

public class Demo {

    public static void main(String[] args) {
        A.B b = new A.B();
        b.setId(null);
        b.setName("");
        b.setPrice(BigDecimal.ZERO);

        A.B b1 = new A.B();
        b1.setId(null);
        b1.setName("");
        b1.setPrice(BigDecimal.ZERO);

        System.out.println(Objects.equals(b, b1));


        System.out.println(1 > 0 && 1 > (1 - 1) * 1 & 1 > 0);

        System.out.println(1 > (1 - 1) * 1 & 1 > 0);

        System.out.println(1 > (1 - 1) * 1);

        System.out.println(1 > 0);
        System.out.println(1>0 && 2>0);
        System.out.println(1>0 & 2>9);
    }
}
