package com.guoyw.storemanagement.entity;

import com.guoyw.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author: guoyw
 * create: 2019-12-23 18:21
 **/
@Entity
@Table(name = "sales_order_to_good", indexes = {
  @Index(name = "sales_order_to_good", columnList = "salesOrderId,goodId")
})
@IdClass(SalesOrderToGoodID.class)
@Data
@Accessors(chain = true)
@ApiModel(description = "销售单-商品")
public class SalesOrderToGood extends BaseEntity{
  
  @ApiModelProperty("销售订单Id")
  @Column
  private Long salesOrderId;
  
  @ApiModelProperty("商品Id")
  @Column
  private Long goodId;
  
}
