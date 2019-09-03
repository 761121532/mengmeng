package com.example.web.Service;

import com.example.web.DAO.UserMapper;
import com.example.web.Entity.LoginMsg;
import com.example.web.Entity.UserEntity;
import com.example.web.ServiceImpl.UserServiceimpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService implements UserServiceimpl {

    private final Logger logger = Logger.getLogger(this.getClass());
    //自动装配 UserMapper的实现类，由容器自动注入 自动销毁
    @Autowired
    UserMapper userMapper;

    //父接口里面定义的方法的实现，逻辑判断都在这里面，本方法用来返回对应id 的用户
    @Override
    public LoginMsg findUser(UserEntity userEntity, HttpSession session) {
        logger.info("log4j test");
        UserEntity userEntity1=userMapper.findUser(userEntity);
        LoginMsg loginMsg=new LoginMsg();
        loginMsg.setErrcode(0);
        if (userEntity1==null){
            loginMsg.setMsg("滚没有这个用户");
            return loginMsg;
        } else if (!userEntity1.getPassword().equals(userEntity.getPassword())){
            loginMsg.setMsg("你TMD密码错了");
            return loginMsg;
        }else {
            session.setAttribute("name",userEntity.getName());
            loginMsg.setErrcode(1);
            loginMsg.setMsg("欢迎回来" + userEntity.getName());
            return loginMsg;
        }
    }

    @Override
    public boolean addUser(UserEntity userEntity) {
        userEntity.setGroupID(2);
        return userMapper.addUser(userEntity);
    }


}
