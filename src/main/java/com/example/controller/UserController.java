package com.example.controller;

import com.example.entity.User;
import com.example.entity.UserInfo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public  String createUser(@RequestBody User user){
        if (user != null){
            userService.createUser(user);
            return "添加用户成功";
        }else {
            return "添加用户失败";
        }
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        User u = userService.findUserById(user.getUid());
        if (u != null){
            userService.updateUser(user);
            return "更新用户成功";
        }else {
            return "更新用户失败";
        }
    }

    @DeleteMapping("{id}")
    public String removeUserById(@PathVariable Integer id){
        User user = userService.findUserById(id);
        if (user == null){
            return "数据库中不存在id为"+id+"的用户";
        }else {
            userService.removeUserById(id);
            return "删除成功";
        }
    }

    @GetMapping("info/{cname}/{username}")
    public List<UserInfo> findUserInfoByUsernameAndCname(@PathVariable String cname,@PathVariable String username){
        return userService.findUserInfoByUsernameAndCname(cname,username);
    }

    @GetMapping("info/{uid}")
    public UserInfo findUserInfoById(@PathVariable Integer uid){
        return userService.findUserInfoById(uid);
    }

    @GetMapping("{uid}")
    public User findUserById(@PathVariable Integer uid){
        return userService.findUserById(uid);
    }

    /**
     * 查找所有用户
     * @return
     */
    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUser();
    }

    /**
     * 查找所有用户信息
     * @return
     */
    @GetMapping("info")
    public List<User> findAllUserInfo() {
        return userService.findAllUserInfo();
    }
}
