package com.guoyw.storemanagement.controller;

import com.guoyw.storemanagement.dto.LoginDto;
import com.guoyw.storemanagement.entity.Good;
import com.guoyw.storemanagement.entity.User;
import com.guoyw.storemanagement.exception.StoreManagementException;
import com.guoyw.storemanagement.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: guoyw
 * create: 2019-12-24 11:48
 **/
@RestController
@RequestMapping("/api/login")
@Api(tags = "登录管理接口")
public class LoginController{
  
  @Autowired
  private UserService userService;
  
  @PostMapping()
  @ApiOperation("登陆")
  public String login(@RequestBody @Validated LoginDto loginDto){
    
    User user = userService.getByUserName(loginDto.getUsername());
    if(user == null)
      throw new StoreManagementException("LOGIN-00002");
    
    if(!user.getPassword().equals(loginDto.getPassword()))
      throw new StoreManagementException("LOGIN-00002");
    
    String token = UUID.randomUUID().toString().replace("-", "");
    user.setToken(token);
    userService.update(user);
    
    return token;
  }
}
