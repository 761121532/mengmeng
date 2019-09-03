package com.example.web.Controller;

import com.example.web.Entity.LoginMsg;
import com.example.web.Entity.UserEntity;
import com.example.web.ServiceImpl.UserServiceimpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    private final
    UserServiceimpl userService;

    public UserController(UserServiceimpl userService) {
        this.userService = userService;
    }

    /**
     * 用来查询用户是否存在的方法
     * @param userEntity userEntity为前端传过来的数据  用userEntity去接收，没有对应的属性则不接收
     * @return 返回一个 对应id 的用户的所有属性
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)  //标注本方法可以接受前端传过来的值 并且路径为find get请求 且返回一个json对象
    public LoginMsg findUser(UserEntity userEntity, HttpSession session){ return userService.findUser(userEntity,session); }

    @RequestMapping(value = "html/getUserName",method = RequestMethod.GET)
    public String findUserName(HttpSession session){return session.getAttribute("name").toString();}

    @RequestMapping(value = "addUser" , method =  RequestMethod.GET)
    public LoginMsg addUser(UserEntity userEntity){
        LoginMsg loginMsg=new LoginMsg();
        if (userService.addUser(userEntity)){
            loginMsg.setErrcode(1);
            loginMsg.setMsg("搞定的啦");
        }else {
            loginMsg.setErrcode(0);
                loginMsg.setMsg("有猫饼");
        }
        return loginMsg;
    }
}
