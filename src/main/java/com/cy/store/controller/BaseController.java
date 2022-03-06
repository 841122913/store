package com.cy.store.controller;

import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 处理异常,封装session
 */
public class BaseController {
    public static final int OK=200;

    @ExceptionHandler(ServiceException.class)//统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result =new JsonResult<>(e);

        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时异常");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("密码不匹配");
        }else if(e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户不存在");
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session
     * @return 返回当前用户的uid
     */

    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(
                session.getAttribute("uid").toString()
        );
        //getAttirbute获取User对象,转成String，再转成Integer
    }

    protected  final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
//    protected  final String getAvatarFromSession(HttpSession session){
//        return session.getAttribute("avatar").toString();
//    }
}
