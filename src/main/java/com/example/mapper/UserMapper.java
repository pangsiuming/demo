package com.example.mapper;

import com.example.entity.User;
import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    void insertUser (User user);//增

    void updateUser (User user);//改

    void deleteUserById (Integer uid);//删

    User findUserByName(@Param("username") String username);//通过name查询User

    List<UserInfo> findUserInfoByUsernameAndCname (@Param("username") String username,@Param("cname") String cname);//通过人名和公司名查询userinfo信息

    UserInfo findUserInfoById(Integer id);//通过用户id查询userinfo信息

    User findUserById(Integer id);//通过用户id查询用户信息

    List<User> findAllUserInfo();//查询所有userinfo信息

    List<User> findAllUsers();//查询所有user信息









}
