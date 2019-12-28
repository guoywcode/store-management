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
@Table(name = "entry_order",
  indexes = {
    @Index(columnList = "id", name = "entry_order_id", unique = true)
  }
)
@Data
@Accessors(chain = true)
@ApiModel(description = "进货订单")
public class EntryOrder extends IdBaseEntity{
  
  @Column(length = 20)
  @ApiModelProperty(value = "操作者id")
  private Long operatorId;
  
  @Column(length = 25)
  @ApiModelProperty(value = "冗余-操作者真实姓名")
  private String operatorIdName;
  
  @Column(length = 50)
  @ApiModelProperty(value = "进货单号")
  private String entryNum;
  
  @Column
  @ApiModelProperty(value = "进货日期")
  private Long entryDate;

  
  @Column
  @ApiModelProperty(value = "实际支付")
  private float actualPay;

  @Column(length = 20)
  @ApiModelProperty(value = "购买客户Id")
  private Long supplierId;
  
  @Column(length = 25)
  @ApiModelProperty(value = "冗余-购买客户真实姓名")
  private Long supplierIdName;
  
  @Column(length = 200)
  @ApiModelProperty(value = "备注")
  private String notes;
}
