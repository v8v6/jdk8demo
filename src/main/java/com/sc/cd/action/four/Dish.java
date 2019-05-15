package com.sc.cd.action.four;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-23 21:01
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String name;

    private boolean vegetarian;

    private int calories;

    private Type type;

    public enum Type { MEAT, FISH, OTHER }
}
