package com.guoyw.storemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: guoyw
 * create: 2019-12-24 09:45
 **/
@Data
@Accessors(chain = true)
@ApiModel(description = "登陆DTO")
public class LoginDto{
  
  @NotEmpty
  @NotNull
  @ApiModelProperty(value = "用户名")
  private String username;
  
  @NotEmpty
  @NotNull
  @ApiModelProperty(value = "密码")
  private String password;
}
