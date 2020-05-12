package com.example.test.controller;

import com.example.test.dao.UserMapper;
import com.example.test.entity.User;
import com.example.test.redis.RedisService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
/**
 * @author Admin
 * @date 2020/5/11
 */
@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    RedisService redisService;


    @RequestMapping("/db/get")
    public User getById(){
        User user = userMapper.getById(1);
        return user;
    }

//    事物测试
    @RequestMapping("/db/tx")
    @ResponseBody
    public boolean dbTx(){
        return userService.tx();
    }

    //redis  测试
    @RequestMapping("/redis/get")
    @ResponseBody
    public String redisGet(){
        //视频的要求，但是不能实现
//        Long v1 = redisService.get("key1",Long.class);
        //自己找的方法
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        String v2 = jedis.get("key1");
        return v2;
    }


    @RequestMapping("/redis/set")
    @ResponseBody
    public String redisSet(){
        //视频的要求，但是不能实现
//        Long v1 = redisService.get("key1",Long.class);
        //自己找的方法
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        String ret = jedis.set("age", "25");
        ret = jedis.get("age");
        return ret;
    }







}
