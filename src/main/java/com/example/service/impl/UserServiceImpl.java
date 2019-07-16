package com.example.service.impl;

import com.example.entity.User;
import com.example.entity.UserInfo;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void removeUserById(Integer uid) {
        userMapper.deleteUserById(uid);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public List<UserInfo> findUserInfoByUsernameAndCname(String username, String cname) {
        return userMapper.findUserInfoByUsernameAndCname(username,cname);
    }

    @Override
    public UserInfo findUserInfoById(Integer id) {
        return userMapper.findUserInfoById(id);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<User> findAllUserInfo() {
        return userMapper.findAllUserInfo();
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUsers();
    }
}
