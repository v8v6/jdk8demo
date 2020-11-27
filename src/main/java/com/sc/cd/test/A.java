package com.sc.cd.test;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class A {

    private B b;

    @Data
    static class B {
        private Long id;

        private String name;

        private BigDecimal price;
    }
}
