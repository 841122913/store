package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.UserSerivce;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController//@ResponseBody以json格式返给前端
//@Controller
@RequestMapping("users")//users是自己设置的请求路径
public class UserController extends  BaseController{
    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping("reg")//reg是自己设置的请求路径
    public JsonResult<Void> reg(User user) {
            userSerivce.reg(user);//交给BaseController关注异常
            return new JsonResult<>(OK);
        }

    /**
     *
     * @param username
     * @param password
     * @return
     */

    @RequestMapping("login")
    public JsonResult<User>login(String username, String password, HttpSession session){//username,password接收前端的数据
           User data= userSerivce.login(username,password);

           //向全局session对象中绑定数据
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        //测试下BaseController中的get from session
        // System.out.println(getUidFromSession(session));
            return new JsonResult<>(OK,data);
        }
}

