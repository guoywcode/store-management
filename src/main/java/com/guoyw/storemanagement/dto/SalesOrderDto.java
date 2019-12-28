package com.guoyw.storemanagement.dto;

import com.guoyw.storemanagement.entity.SalesOrder;
import com.guoyw.storemanagement.entity.SalesOrderToGood;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-24 09:45
 **/
@Data
@Accessors(chain = true)
@ApiModel(description = "销售订单DTO")
public class SalesOrderDto{
  
  @ApiModelProperty(value = "销售订单Id")
  private String salesOrderId;
  
  @ApiModelProperty(value = "销售订单")
  private SalesOrder salesOrder;
  
  @ApiModelProperty(value = "销售订单-商品列表")
  private List<SalesOrderToGood> salesOrderToGoodList;
}
