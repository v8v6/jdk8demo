package com.sc.cd.poi;

import java.math.BigDecimal;

import cn.afterturn.easypoi.excel.annotation.Excel;

import lombok.Data;

@Data
public class FlTaskOrderExportDTO {

  @Excel(name = "任务名称")
  private String name;

  @Excel(name = "项目名称")
  private String projectName;

  @Excel(name = "企业名称")
  private String companyName;

  @Excel(name = "任务编码")
  private String code;

  @Excel(name = "任务状态")
  private String status;

  @Excel(name = "备注说明")
  private String remark;

  @Excel(name = "执行人姓名")
  private String memberName;

  @Excel(name = "执行人手机")
  private String memberMobile;

  @Excel(name = "本月度累计税前收入")
  private BigDecimal monthTotalIncoming;

  @Excel(name = "截至上月年度计税依据")
  private BigDecimal lastMonthYearTaxBasis;

  @Excel(name = "任务税前金额")
  private BigDecimal totalPrice;

  @Excel(name = "平台服务费率")
  private String serverRate;

  @Excel(name = "平台服务费")
  private BigDecimal serverFee;

  @Excel(name = "任务税后金额")
  private BigDecimal actualPay;

  @Excel(name = "增值税")
  private BigDecimal vat;

  @Excel(name = "个人所得税")
  private BigDecimal tax;

  @Excel(name = "银行流水号")
  private String bankFlowNumber;

  @Excel(name = "付款凭证编号")
  private String payVoucherCode;

  @Excel(name = "支付时间(打款时间)")
  private String payTime;

  @Excel(name = "支付结果")
  private String payStatus;

  @Excel(name = "异常原因")
  private String errorMessage;

  @Excel(name = "执行人银行卡号")
  private String cardNumber;

  @Excel(name = "执行人银行名称")
  private String bankName;

  @Excel(name = "执行人开户行")
  private String openBank;

}
