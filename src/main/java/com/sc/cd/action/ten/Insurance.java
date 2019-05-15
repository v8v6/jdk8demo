package com.sc.cd.action.ten;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-25 17:19
 */

@Data
@Builder
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class Insurance {

    private String name;
}
