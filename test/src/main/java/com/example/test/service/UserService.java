package com.example.test.service;

import com.example.test.entity.User;

/**
 * @author Admin
 * @date 2020/5/11
 */
public interface UserService {
    public User getById(int id);

    boolean tx();
}
