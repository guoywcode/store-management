package com.guoyw.storemanagement.biz;

import com.guoyw.storemanagement.dto.EntryOrderDto;
import com.guoyw.storemanagement.entity.EntryOrder;
import com.guoyw.storemanagement.entity.EntryOrderToGood;
import com.guoyw.storemanagement.exception.StoreManagementException;
import com.guoyw.storemanagement.service.EntryOrderService;
import com.guoyw.storemanagement.service.EntryOrderToGoodService;
import com.guoyw.utils.SpringBeanUtilsExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-24 10:07
 **/
@Component
public class EntryOrderBiz{
  
  @Autowired
  private EntryOrderService entryOrderService;
  @Autowired
  private EntryOrderToGoodService entryOrderToGoodService;
  
  
  //region replace进货订单
  public void replace(EntryOrderDto entryOrderDto){
    if(entryOrderDto == null)
      throw new StoreManagementException("ENTRY-ORDER-PARAM-00002");
    
    if(entryOrderDto.getEntryOrderId() == null || entryOrderDto.getEntryOrderId().equals(0)){
      if(entryOrderDto.getEntryOrder() == null)
        throw new StoreManagementException("ENTRY-ORDER-PARAM-00001");
      
      EntryOrder dbEntryOrder = entryOrderService.create(entryOrderDto.getEntryOrder());
      entryOrderDto.getEntryOrderToGoodList().forEach(entryOrderToGood->entryOrderToGood.setEntryOrderId(dbEntryOrder.getId()));
      entryOrderToGoodService.createAll(entryOrderDto.getEntryOrderToGoodList());
    }else{
      EntryOrder dbEntryOrder = entryOrderService.getById(entryOrderDto.getEntryOrderId());
      SpringBeanUtilsExt.copyPropertiesIgnoreNull(entryOrderDto.getEntryOrder(),dbEntryOrder,"id");
      entryOrderService.update(dbEntryOrder);
      // 删除所有商品重新添加
      entryOrderToGoodService.removeAllByEntryOrderId(dbEntryOrder.getId());
      entryOrderDto.getEntryOrderToGoodList().forEach(entryOrderToGood->entryOrderToGood.setEntryOrderId(dbEntryOrder.getId()));
      entryOrderToGoodService.createAll(entryOrderDto.getEntryOrderToGoodList());
    }
    
  }
  //endregion
  
  //region replace进货订单
  public EntryOrderDto details(String id){
    EntryOrderDto entryOrderDto = new EntryOrderDto();
    EntryOrder entryOrder = entryOrderService.getById(id);
    List<EntryOrderToGood> entryOrderToGoodList = entryOrderToGoodService.getAllByEntryOrderId(id);
    
    entryOrderDto.setEntryOrder(entryOrder)
      .setEntryOrderToGoodList(entryOrderToGoodList)
      .setEntryOrderId(entryOrder.getId());
    return entryOrderDto;
  }
  //endregion
}
