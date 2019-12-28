package com.guoyw.storemanagement.dto;

import com.guoyw.storemanagement.entity.EntryOrder;
import com.guoyw.storemanagement.entity.EntryOrderToGood;
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
@ApiModel(description = "进货订单DTO")
public class EntryOrderDto{
  
  @ApiModelProperty(value = "进货订单Id")
  private String entryOrderId;
  
  
  @ApiModelProperty(value = "进货订单")
  private EntryOrder entryOrder;
  
  @ApiModelProperty(value = "进货订单-商品列表")
  private List<EntryOrderToGood> entryOrderToGoodList;
}
