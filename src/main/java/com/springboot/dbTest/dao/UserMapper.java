package com.springboot.dbTest.dao;

import com.springboot.dbTest.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//@Mapper
public interface UserMapper {
    void add(User user);
    
    List<Map<String,String>> list();
}
