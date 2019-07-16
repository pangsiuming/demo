package com.example.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private List<User> users;

    private String cname;

    private String city;
}
