package com.example.test.service.impl;

import com.example.test.dao.UserMapper;
import com.example.test.entity.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Admin
 * @date 2020/5/11
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
//    @Transactional
//    @Transactional    不设置事物的时候，数据二是可以被插进去的
    public boolean tx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("利尔");
        userMapper.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("1111");
        userMapper.insert(u2);
        return true;
    }
}
