package com.guoyw.storemanagement.service;

import com.guoyw.base.repository.BaseRepository;
import com.guoyw.base.supportid.service.IdBaseService;
import com.guoyw.storemanagement.entity.Good;
import com.guoyw.storemanagement.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:17
 **/
@Service
public class GoodService implements IdBaseService<Good> {

    @Autowired
    private GoodRepository goodRepository;

    @Override
    public BaseRepository<Good, String> getRepository() {
        return goodRepository;
    }
    
    public Good getByGoodName(String goodName){
        return goodRepository.findByGoodName(goodName);
    }
}
