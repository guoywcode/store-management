package com.guoyw.storemanagement.entity;

import com.guoyw.base.supportid.entity.IdBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author: guoyw
 * create: 2019-12-23 17:47
 **/
@Entity
@Table(name = "sales_order",
  indexes = {
    @Index(columnList = "id", name = "sales_order_id", unique = true)
  }
)
@Data
@Accessors(chain = true)
@ApiModel(description = "销售订单")
public class SalesOrder extends IdBaseEntity{
  
  @Column(length = 20)
  @ApiModelProperty(value = "操作者id")
  private String operatorId;
  
  @Column(length = 25)
  @ApiModelProperty(value = "冗余-操作者真实姓名")
  private String operatorIdName;
  
  @Column(length = 50)
  @ApiModelProperty(value = "销售单号")
  private String saleNum;
  
  @Column
  @ApiModelProperty(value = "销售日期")
  private Long saleDate;
  
  @Column
  @ApiModelProperty(value = "总金额")
  private float saleTotalSum;
  
  @Column
  @ApiModelProperty(value = "折扣")
  private float saleDiscount;
  
  @Column
  @ApiModelProperty(value = "折扣后金额")
  private float saleDiscountSum;
  
  @Column
  @ApiModelProperty(value = "实际支付")
  private float actualPay;
  
  @Column
  @ApiModelProperty(value = "欠款金额")
  private float debtSum;
  
  @Column(length = 20)
  @ApiModelProperty(value = "购买客户Id")
  private String customerPurchasesId;
  
  @Column(length = 25)
  @ApiModelProperty(value = "冗余-购买客户真实姓名")
  private Long customerPurchasesIdName;
  
  @Column(length = 200)
  @ApiModelProperty(value = "备注")
  private String notes;
}
