package com.sc.cd.jdk8.predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-20 16:03
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
}
