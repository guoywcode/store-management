package com.guoyw.storemanagement.controller;


import com.guoyw.storemanagement.biz.EntryOrderBiz;
import com.guoyw.storemanagement.dto.EntryOrderDto;
import com.guoyw.storemanagement.entity.EntryOrder;
import com.guoyw.storemanagement.service.EntryOrderService;
import com.guoyw.storemanagement.service.EntryOrderToGoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-24 09:03
 **/
@RestController
@RequestMapping("/api/entryOrder")
@Api(tags = "进货单管理接口")
public class EntryOrderController{
  
  @Autowired
  private EntryOrderService entryOrderService;
  @Autowired
  private EntryOrderToGoodService entryOrderToGoodService;
  @Autowired
  private EntryOrderBiz entryOrderBiz;
  
  @PostMapping
  @ApiOperation("添加 OR 编辑 进货订单")
  public void replace(@RequestBody EntryOrderDto entryOrderDto) {
     entryOrderBiz.replace(entryOrderDto);
  }
  
  
  @DeleteMapping(path = "{id}")
  @ApiOperation("删除")
  @Transactional
  public void remove(@PathVariable("id") String id) {
    entryOrderService.removeById(id);
    entryOrderToGoodService.removeAllByEntryOrderId(id);
  }
  
  @GetMapping(path = "{id}")
  @ApiOperation("详情")
  public EntryOrderDto details(@PathVariable("id") String id) {
    return entryOrderBiz.details(id);
  }
  
  @GetMapping(path = "getList")
  @ApiOperation("获取进货订单列表")
  public List<EntryOrder> getList(){
   return entryOrderService.getAll();
  }
  
}
