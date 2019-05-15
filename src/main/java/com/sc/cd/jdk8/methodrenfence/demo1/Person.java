package com.sc.cd.jdk8.methodrenfence.demo1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 13:42
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    private String firstName;

    private String lastName;
}
