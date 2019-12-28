package com.guoyw.storemanagement.repository;

import com.guoyw.base.repository.BaseRepository;
import com.guoyw.storemanagement.entity.EntryOrderToGood;
import com.guoyw.storemanagement.entity.EntryOrderToGoodID;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:11
 **/
@Repository
public interface EntryOrderToGoodRepository extends BaseRepository<EntryOrderToGood, EntryOrderToGoodID> {
  void removeAllByEntryOrderId(String entryOrderId);
  
  List<EntryOrderToGood> findAllByEntryOrderId(String entryOrderId);
}
