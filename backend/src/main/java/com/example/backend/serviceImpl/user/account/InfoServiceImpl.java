package com.example.backend.serviceImpl.user.account;

import com.example.backend.pojo.user;
import com.example.backend.service.user.account.InfoService;
import com.example.backend.serviceImpl.utils.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Map<String, String> getinfo() {
        //如果授权成功 则从上下文中将User信息提取出来
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();

        user user = loginUser.getUser();
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("avatar", user.getAvatar());
        return map;
    }
}
