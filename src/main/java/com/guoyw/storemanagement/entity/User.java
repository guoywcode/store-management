package com.guoyw.storemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "user",
  indexes = {
    @Index(columnList = "id", name = "user_id", unique = true)
  }
)
@Data
@Accessors(chain = true)
@ApiModel(description = "用户")
public class User extends IdBaseEntity{
  
  @Column(length = 20)
  @ApiModelProperty(value = "用户名")
  private String userName;
  
  @Column(length = 32)
  @ApiModelProperty(value = "密码")
  private String password;
  
  @Column(length = 25)
  @ApiModelProperty(value = "真实姓名")
  private String IdName;
  
  @ApiModelProperty("性别")
  @Column(length = 2)
  private String gender;
  
  @ApiModelProperty("身份证号")
  @Column(length = 18)
  private String idNumber;
  
  @ApiModelProperty("手机号")
  @Column(length = 20)
  private String phone;
  
  @ApiModelProperty("工作单位")
  @Column(length = 100)
  private String jobUnit;
  
  @ApiModelProperty("用户角色(管理员-admin、顾客-customer、供货商-supplier)")
  @Column(length = 100)
  private String role;
  
  @ApiModelProperty("用户登录token")
  @Column(length = 32)
  @JsonIgnore
  private String token;
  
  @ApiModelProperty("用户最后登录时间")
  @Column(length = 32)
  @JsonIgnore
  private Long lastLoginTime;
}
