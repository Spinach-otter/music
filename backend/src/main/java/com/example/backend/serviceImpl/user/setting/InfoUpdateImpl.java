package com.example.backend.serviceImpl.user.setting;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.user;
import com.example.backend.service.user.setting.InfoUpdate;
import com.example.backend.serviceImpl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoUpdateImpl implements InfoUpdate {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, String> update(Map<String, String> data) {
        //1. 获取User
        //同InfoServiceImpl一样 如果授权成功 则从上下文中将User信息提取出来
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        user user = loginUser.getUser();

        //2. 获取data内容
        String username = data.get("username");

        Map<String,String> map = new HashMap<>();//定义return格式

        //语法检查
        if(username == null || username.length() == 0){
            map.put("error_message","用户名不能为空");
            return map;
        }
//        System.out.println(user);
//        System.out.println(data);

        //更新

        user new_user = new user(
                user.getId(),
                user.getAvatar(),
                username,
                user.getPassword()
        );
        userMapper.updateById(new_user);

//        System.out.println(userMapper.selectById(4));
        map.put("error_message","success");
        return map;
    }
}
