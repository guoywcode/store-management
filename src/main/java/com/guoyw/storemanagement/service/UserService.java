package com.guoyw.storemanagement.service;

import com.guoyw.base.repository.BaseRepository;
import com.guoyw.base.supportid.service.IdBaseService;
import com.guoyw.storemanagement.entity.User;
import com.guoyw.storemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: store-management
 * @description:
 * @author: guoyw
 * @create: 2019-12-23 22:17
 **/
@Service
public class UserService implements IdBaseService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseRepository<User, String> getRepository() {
        return userRepository;
    }
    
    public User getByUserName(String username){
        return userRepository.findByUserName(username);
    }
    
    public User getByToken(String token){
        long time = new Date().getTime();
        long lastTime = time - Integer.valueOf("1800000");
       return userRepository.findByTokenAndLastLoginTimeGreaterThan(token,lastTime);
    }
    
    public List<User> getAllByRole(String role){
        return userRepository.findAllByRole(role);
    }
}
