package com.sc.cd.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-20 11:35
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String groupId;

    private String name;
}
