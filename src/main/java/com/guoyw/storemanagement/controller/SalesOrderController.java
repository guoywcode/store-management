package com.guoyw.storemanagement.controller;

import com.guoyw.storemanagement.biz.SalesOrderBiz;
import com.guoyw.storemanagement.dto.SalesOrderDto;
import com.guoyw.storemanagement.entity.SalesOrder;
import com.guoyw.storemanagement.service.SalesOrderService;
import com.guoyw.storemanagement.service.SalesOrderToGoodService;
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
@RequestMapping("/api/salesOrder")
@Api(tags = "销售单管理接口")
public class SalesOrderController{
  
  @Autowired
  private SalesOrderService salesOrderService;
  @Autowired
  private SalesOrderToGoodService salesOrderToGoodService;
  @Autowired
  private SalesOrderBiz salesOrderBiz;
  
  @PostMapping
  @ApiOperation("添加 OR 编辑 销售订单")
  public void replace(@RequestBody SalesOrderDto salesOrderDto) {
    salesOrderBiz.replace(salesOrderDto);
  }
  
  
  @DeleteMapping(path = "{id}")
  @ApiOperation("删除")
  @Transactional
  public void remove(@PathVariable("id") String id) {
    salesOrderService.removeById(id);
    salesOrderToGoodService.removeAllBySalesOrderId(id);
  }
  
  @GetMapping(path = "{id}")
  @ApiOperation("详情")
  public SalesOrderDto details(@PathVariable("id") String id) {
    return salesOrderBiz.details(id);
  }
  
  @GetMapping(path = "getList")
  @ApiOperation("获取销售订单列表")
  public List<SalesOrder> getList(){
    return salesOrderService.getAll();
  }
  
}
