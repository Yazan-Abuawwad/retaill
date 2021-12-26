package com.retail.demo.controller;


import com.retail.demo.entity.UserEntity;
import com.retail.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserResource {


    @Autowired
    private UserService userService;





    @GetMapping("/users")
    // @EmployeeSecurity
    public List<UserEntity> getAllUsers() {

        return userService.getAllUsers();
    }


    @PostMapping("/user")
    public UserEntity createUser(@RequestBody UserEntity Users) throws URISyntaxException {


        UserEntity result = userService.create(Users);
        return result;
    }


}
