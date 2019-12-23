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
 * create: 2019-12-23 17:25
 **/
@Entity
@Table(name = "good",
  indexes = {
    @Index(columnList = "id", name = "good_id", unique = true)
  }
)
@Data
@Accessors(chain = true)
@ApiModel(description = "商品")
public class Good extends IdBaseEntity{
  
  @Column(length = 50)
  @ApiModelProperty(value = "商品名称")
  private String goodName;
  
  @Column(length = 20)
  @ApiModelProperty(value = "商品类型")
  private String goodCategory;
  
  @Column(length = 20)
  @ApiModelProperty(value = "商品单位")
  private String goodUnit;
  
  @Column(length = 20)
  @ApiModelProperty(value = "商品库存数量")
  private String goodNum;
  
  @Column(length = 20)
  @ApiModelProperty(value = "进货价格")
  private String entryPrice ;
  
  @Column(length = 20)
  @ApiModelProperty(value = "零售价格")
  private String salePrice ;
  
}
