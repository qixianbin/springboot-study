package com.springboot.dbTest.action;

import com.springboot.dbTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserAction {
    
    @Autowired
    UserService service;
    
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "hello";
    };
    
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public List<Map<String,String>> getUserList(){
        return service.list();
    };
    
    @RequestMapping("/addUser")
    public void add(){
        service.add();
    }
}
