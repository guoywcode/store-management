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
@Table(name = "entry_order_to_good", indexes = {
  @Index(name = "entry_order_to_good", columnList = "entryOrderId,goodId")
})
@IdClass(EntryOrderToGoodID.class)
@Data
@Accessors(chain = true)
@ApiModel(description = "进货单-商品")
public class EntryOrderToGood extends BaseEntity{
  @Id
  @Column(length = 20)
  @ApiModelProperty("进货订单Id")
  private String entryOrderId;
  
  @Id
  @Column(length = 20)
  @ApiModelProperty("商品Id")
  private String goodId;

  @ApiModelProperty("进货数量")
  @Column
  private Long entryVolume;

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
  @ApiModelProperty(value = "进货价格")
  private String entryPrice;
  
  @Column(length = 20)
  @ApiModelProperty(value = "供货商Id")
  private String supplierId;
  
  
}
