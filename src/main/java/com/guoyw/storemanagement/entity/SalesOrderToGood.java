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
  
  @Id
  @Column(length = 20)
  @ApiModelProperty("销售订单Id")
  private String salesOrderId;
  
  @Id
  @Column(length = 20)
  @ApiModelProperty("商品Id")
  private String goodId;

  @ApiModelProperty("销售数量")
  @Column
  private Long salesVolume;

  @Column(length = 50)
  @ApiModelProperty(value = "冗余-商品名称")
  private String goodName;

  @Column(length = 20)
  @ApiModelProperty(value = "冗余-商品类型")
  private String goodCategory;

  @Column(length = 20)
  @ApiModelProperty(value = "冗余-商品单位")
  private String goodUnit;

  @Column(length = 20)
  @ApiModelProperty(value = "冗余-零售价格")
  private String salePrice ;


}
