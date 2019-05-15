package com.sc.cd.action.five;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-24 09:14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Trader trader;

    private int year;

    private int value;
}
