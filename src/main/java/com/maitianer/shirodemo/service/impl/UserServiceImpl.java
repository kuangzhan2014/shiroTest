package com.maitianer.shirodemo.service.impl;

import com.maitianer.shirodemo.domain.User;
import com.maitianer.shirodemo.mapper.UserMapper;
import com.maitianer.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhou
 * @Date: 2019/06/28 15:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
