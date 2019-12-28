package com.guoyw.storemanagement.service;

import com.guoyw.base.repository.BaseRepository;
import com.guoyw.base.service.BaseService;
import com.guoyw.storemanagement.entity.SalesOrderToGood;
import com.guoyw.storemanagement.entity.SalesOrderToGoodID;
import com.guoyw.storemanagement.repository.SalesOrderToGoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:17
 **/
@Service
public class SalesOrderToGoodService implements BaseService<SalesOrderToGood, SalesOrderToGoodID>{
  
  @Autowired
  private SalesOrderToGoodRepository salesOrderToGoodRepository;
  
  @Override
  public BaseRepository<SalesOrderToGood, SalesOrderToGoodID> getRepository(){
    return salesOrderToGoodRepository;
  }
  
  public void removeAllBySalesOrderId(String salesOrderId){
    salesOrderToGoodRepository.removeAllBySalesOrderId(salesOrderId);
  }
  
  public List<SalesOrderToGood> getAllBySalesOrderId(String salesOrderId){
    return salesOrderToGoodRepository.findAllBySalesOrderId(salesOrderId);
  }
}
