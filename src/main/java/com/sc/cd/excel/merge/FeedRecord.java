package com.sc.cd.excel.merge;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedRecord {

    @ExcelProperty("纵队")
    private String team;

    @ExcelProperty("战区/聚落")
    private String warZone;

    @ExcelProperty("公司")
    private String company;

    @ExcelProperty("场线")
    private String line;

    @ExcelProperty(value = "批次", index = 4)
    private String batch;

    @ExcelProperty(value = "饲喂日期", index = 5)
    private String feedingDate;

    @ExcelProperty("存栏量")
    private int stock;

    @ExcelProperty("日龄")
    private int dayAge;

    @ExcelProperty("物料")
    private String material;

    @ExcelProperty("料塔投料量(kg)")
    private int towerFeedingAmount;

    @ExcelProperty("实际投料量(kg)")
    private int actualFeedingAmount;

    @ExcelProperty("投料偏差(kg)")
    private int feedingDeviation;

    @ExcelProperty("统计周期")
    private String statisticalPeriod;

    @ExcelProperty("自动饲喂状态")
    private String autoFeedingStatus;

    @ExcelProperty("失败原因")
    private String failureReason;
}
