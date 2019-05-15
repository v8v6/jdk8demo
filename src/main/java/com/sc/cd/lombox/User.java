package com.sc.cd.lombox;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 22:37
 */

@Getter
@Builder(toBuilder = true)
@ToString
public class User {

    private Integer id;

    private String name;

    private Date createTime;
}
