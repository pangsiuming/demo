package com.example.service;

import com.example.entity.User;
import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
     void createUser (User user);//增

     void updateUser (User user);//改

     void removeUserById (Integer uid);//删

     User findUserByName(@Param("username") String username);//通过name查询User

     List<UserInfo> findUserInfoByUsernameAndCname (@Param("username") String username, @Param("cname") String cname);//通过人名和公司名查询userinfo信息

     UserInfo findUserInfoById(Integer id);//通过用户id查询userinfo信息

     User findUserById(Integer id);//通过用户id查询用户信息

     List<User> findAllUserInfo();//查询所有userinfo信息

     List<User> findAllUser();//查询所有user信息
}
