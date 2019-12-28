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
@ApiModel(description = "进货单-商品 ID")
public class EntryOrderToGoodID implements Serializable{
  
  @ApiModelProperty("进货订单Id")
  @Column(length = 20)
  private String entryOrderId;
  
  @ApiModelProperty("商品Id")
  @Column(length = 20)
  private String goodId;
  
}
