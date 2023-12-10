package com.example.backend.controller;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class testController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    public String test() {
        return "hello!";
    }

    @RequestMapping("/user")
    public List<user> user() {
        return userMapper.selectList(null);
    }
}
