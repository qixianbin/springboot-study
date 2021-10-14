package com.springboot.dbTest.service;

import com.springboot.dbTest.dao.UserMapper;
import com.springboot.dbTest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService2 {
    
    @Resource
    UserMapper dao;
    
    @Transactional
    public void add2(){
        User u = new User();
        u.setUserName("李四");
        u.setAge(13);
        dao.add(u);
        throw new RuntimeException("123");
    }
}
