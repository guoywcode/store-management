package com.guoyw.storemanagement.controller;

import com.guoyw.base.supportid.controller.IdBaseController;
import com.guoyw.base.supportid.service.IdBaseService;
import com.guoyw.storemanagement.entity.User;
import com.guoyw.storemanagement.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-24 09:03
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户管理接口")
public class UserController extends IdBaseController<User>{
  
  @Autowired
  private UserService userService;
  
  @Override
  protected IdBaseService<User> getService(){
    return userService;
  }
  
  @GetMapping(path = "getListByRole")
  @ApiOperation("获取用户列表-根据role")
  public List<User> getListByRole(String role){
    return userService.getAllByRole(role);
  }
  
}
