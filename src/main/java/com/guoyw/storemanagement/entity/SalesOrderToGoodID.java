package com.guoyw.storemanagement.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author: guoyw
 * create: 2019-12-23 18:19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "销售单-商品 ID")
public class SalesOrderToGoodID implements Serializable{
  
  @ApiModelProperty("销售订单Id")
  @Column(length = 32)
  private String salesOrderId;
  
  @ApiModelProperty("商品Id")
  @Column(length = 32)
  private String goodId;
  
}
