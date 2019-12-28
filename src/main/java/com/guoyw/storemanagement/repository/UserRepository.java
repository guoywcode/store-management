package com.guoyw.storemanagement.repository;

import com.guoyw.base.supportid.repository.IdBaseRepository;
import com.guoyw.storemanagement.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:11
 **/
@Repository
public interface UserRepository extends IdBaseRepository<User> {
  
  User findByUserName(String username);
  
  User findByTokenAndLastLoginTimeGreaterThan(String token,Long lastLoginTime);
  
  List<User> findAllByRole(String role);
  
}
