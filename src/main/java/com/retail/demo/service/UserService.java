package com.retail.demo.service;

import com.retail.demo.entity.UserEntity;
import com.retail.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

     @Autowired
    private UserRepo userRepo;

    public List<UserEntity> getAllUsers() {
        return  userRepo.findAll();
    }


    public UserEntity create(UserEntity user) {
        return userRepo.save(user);
    }
}
