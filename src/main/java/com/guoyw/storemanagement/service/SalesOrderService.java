package com.guoyw.storemanagement.service;

import com.guoyw.base.repository.BaseRepository;
import com.guoyw.base.supportid.service.IdBaseService;
import com.guoyw.storemanagement.entity.SalesOrder;
import com.guoyw.storemanagement.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:17
 **/
@Service
public class SalesOrderService implements IdBaseService<SalesOrder> {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Override
    public BaseRepository<SalesOrder, String> getRepository() {
        return salesOrderRepository;
    }
}
