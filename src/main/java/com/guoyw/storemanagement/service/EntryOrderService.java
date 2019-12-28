package com.guoyw.storemanagement.service;

import com.guoyw.base.repository.BaseRepository;
import com.guoyw.base.supportid.service.IdBaseService;
import com.guoyw.storemanagement.entity.EntryOrder;
import com.guoyw.storemanagement.repository.EntryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:17
 **/
@Service
public class EntryOrderService implements IdBaseService<EntryOrder> {

    @Autowired
    private EntryOrderRepository entryOrderRepository;

    @Override
    public BaseRepository<EntryOrder, String> getRepository() {
        return entryOrderRepository;
    }
}
