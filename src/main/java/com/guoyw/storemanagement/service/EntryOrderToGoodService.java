package com.guoyw.storemanagement.service;

import com.guoyw.base.repository.BaseRepository;
import com.guoyw.base.service.BaseService;
import com.guoyw.storemanagement.entity.EntryOrderToGood;
import com.guoyw.storemanagement.entity.EntryOrderToGoodID;
import com.guoyw.storemanagement.repository.EntryOrderToGoodRepository;
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
public class EntryOrderToGoodService implements BaseService<EntryOrderToGood, EntryOrderToGoodID> {

    @Autowired
    private EntryOrderToGoodRepository entryOrderToGoodRepository;
    
    @Override
    public BaseRepository<EntryOrderToGood, EntryOrderToGoodID> getRepository() {
        return entryOrderToGoodRepository;
    }
    
    public void removeAllByEntryOrderId(String entryOrderId){
        entryOrderToGoodRepository.removeAllByEntryOrderId(entryOrderId);
    }
    
    public List<EntryOrderToGood> getAllByEntryOrderId(String entryOrderId){
        return entryOrderToGoodRepository.findAllByEntryOrderId(entryOrderId);
    }
}
