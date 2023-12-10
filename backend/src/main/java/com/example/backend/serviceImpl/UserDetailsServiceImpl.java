package com.example.backend.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.user;
import com.example.backend.serviceImpl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        user user=userMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }
        return new UserDetailsImpl(user);
    }
}
