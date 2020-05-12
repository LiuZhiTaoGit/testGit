package com.example.test.dao;

import com.example.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//这个注解可不能忘啊
@Mapper
public interface UserMapper {

    User getById(int id);
    int insert(User user);
}