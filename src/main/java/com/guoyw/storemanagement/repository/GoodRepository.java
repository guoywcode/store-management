package com.guoyw.storemanagement.repository;

import com.guoyw.base.supportid.repository.IdBaseRepository;
import com.guoyw.storemanagement.entity.Good;
import org.springframework.stereotype.Repository;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:11
 **/
@Repository
public interface GoodRepository extends IdBaseRepository<Good> {
  Good findByGoodName(String goodName);
}
