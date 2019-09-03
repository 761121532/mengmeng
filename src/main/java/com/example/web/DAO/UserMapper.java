package com.example.web.DAO;

import com.example.web.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

                //dao层，用来做数据持久的接口。
@Mapper        //注解标记这个接口作为一个映射接口
@Repository    //用来表明该类是用来执行与数据库相关的操作（即dao对象）
public interface UserMapper {
    //可访问程度 默认   作用 传入一个用户name  返回指定用户的所有数据
    UserEntity findUser(UserEntity userentity);
    //添加用户信息
    boolean addUser(UserEntity userEntity);
}
