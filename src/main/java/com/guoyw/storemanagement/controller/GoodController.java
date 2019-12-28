package com.guoyw.storemanagement.controller;

import com.guoyw.base.supportid.controller.IdBaseController;
import com.guoyw.base.supportid.service.IdBaseService;
import com.guoyw.storemanagement.entity.Good;
import com.guoyw.storemanagement.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-24 09:03
 **/
@RestController
@RequestMapping("/api/good")
@Api(tags = "商品管理接口")
public class GoodController extends IdBaseController<Good>{
  
  @Autowired
  private GoodService goodService;
  
  @Override
  protected IdBaseService<Good> getService(){
    return goodService;
  }
  
  @GetMapping(path = "getList")
  @ApiOperation("商品列表")
  public List<Good> getList(){
    List<Good> goodList = goodService.getAll();
     return goodList;
  }
  
  @GetMapping(path = "verifyDbIsExistByGoodName")
  @ApiOperation("校验是否已存在-商品")
  public boolean verifyDbIsExistByGoodName(String goodName){
    Good good = goodService.getByGoodName(goodName);
    if(good != null)
      return false;
    return true;
  }
  
}
