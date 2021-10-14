package com.springboot.dbTest.service;

import com.springboot.dbTest.dao.UserMapper;
import com.springboot.dbTest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    
    @Resource
    UserMapper dao;
    
    @Autowired
    UserService2 service2;
    
//    @Transactional
    public void add(){
        User u = new User();
        u.setUserName("张三");
        u.setAge(13);
        dao.add(u);
//        add2();
        service2.add2();
        throw new RuntimeException("123");
    }
    
    @Transactional
    public void add2(){
        User u = new User();
        u.setUserName("李四");
        u.setAge(13);
        dao.add(u);
        throw new RuntimeException("123");
    }
    
    public List<Map<String,String>> list(){
        return dao.list();
    }
}
