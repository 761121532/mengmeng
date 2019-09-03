package com.example.web.ServiceImpl;

import com.example.web.Entity.LoginMsg;
import com.example.web.Entity.UserEntity;

import javax.servlet.http.HttpSession;

public interface UserServiceimpl {
    //查询用户的方法 必须要参数id值
    LoginMsg findUser(UserEntity userEntity , HttpSession session);
    //添加用户的方法
    boolean addUser(UserEntity userEntity);
}
