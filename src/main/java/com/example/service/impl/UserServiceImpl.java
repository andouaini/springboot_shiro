package com.example.service.impl;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zhaoluowei
 * @Date 2019/7/4  23:41
 * @Version 1.0
 */

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findAllUserInfoByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user!=null){
            List<Role> roles = roleMapper.findRoleListByUserId(user.getId());
            user.setRoleList(roles);
            return user;
        }
       return null;
    }

    @Override
    public User findSimpleUserInfoById(int userId) {
        User user = userMapper.findById(userId);
        return user;
    }

    @Override
    public User findSimpleUserInfoByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
}
