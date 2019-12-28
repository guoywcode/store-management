package com.guoyw.storemanagement.biz;

import com.guoyw.storemanagement.dto.SalesOrderDto;
import com.guoyw.storemanagement.entity.SalesOrder;
import com.guoyw.storemanagement.entity.SalesOrderToGood;
import com.guoyw.storemanagement.exception.StoreManagementException;
import com.guoyw.storemanagement.service.SalesOrderService;
import com.guoyw.storemanagement.service.SalesOrderToGoodService;
import com.guoyw.utils.SpringBeanUtilsExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-24 10:07
 **/
@Component
public class SalesOrderBiz{
  
  @Autowired
  private SalesOrderService salesOrderService;
  @Autowired
  private SalesOrderToGoodService salesOrderToGoodService;
  
  
  //region replace销售订单
  public void replace(SalesOrderDto salesOrderDto){
    if(salesOrderDto == null)
      throw new StoreManagementException("ENTRY-ORDER-PARAM-00002");
    
    if(salesOrderDto.getSalesOrderId() == null || salesOrderDto.getSalesOrderId().equals(0)){
      SalesOrder dbSalesOrder = salesOrderService.create(salesOrderDto.getSalesOrder());
      salesOrderDto.getSalesOrderToGoodList().forEach(salesOrderToGood->salesOrderToGood.setSalesOrderId(dbSalesOrder.getId()));
      salesOrderToGoodService.createAll(salesOrderDto.getSalesOrderToGoodList());
    }else{
      SalesOrder dbSalesOrder = salesOrderService.getById(salesOrderDto.getSalesOrderId());
      SpringBeanUtilsExt.copyPropertiesIgnoreNull(salesOrderDto.getSalesOrder(),dbSalesOrder,"id");
      salesOrderService.update(dbSalesOrder);
      // 删除所有商品重新添加
      salesOrderToGoodService.removeAllBySalesOrderId(dbSalesOrder.getId());
      salesOrderDto.getSalesOrderToGoodList().forEach(salesOrderToGood->salesOrderToGood.setSalesOrderId(dbSalesOrder.getId()));
      salesOrderToGoodService.createAll(salesOrderDto.getSalesOrderToGoodList());
    }
    
  }
  //endregion
  
  //region replace销售订单
  public SalesOrderDto details(String id){
    SalesOrderDto salesOrderDto = new SalesOrderDto();
    SalesOrder salesOrder = salesOrderService.getById(id);
    List<SalesOrderToGood> salesOrderToGoods = salesOrderToGoodService.getAllBySalesOrderId(id);
  
    salesOrderDto.setSalesOrder(salesOrder)
      .setSalesOrderToGoodList(salesOrderToGoods)
      .setSalesOrderId(salesOrder.getId());
    return salesOrderDto;
  }
  //endregion
}
