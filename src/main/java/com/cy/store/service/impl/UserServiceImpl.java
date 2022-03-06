package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.UserSerivce;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.PasswordNotMatchException;
import com.cy.store.service.ex.UserNotFoundException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 实现业务层接口
 */
@Service//关键！Error creating bean
public class UserServiceImpl implements UserSerivce {
    //传递mapper层找到的user对象
    @Autowired
    private UserMapper userMapper;

    private String getMD5Pwd(String pwd,String salt){
        for (int i = 0; i <3 ; i++) {
            pwd = DigestUtils.md5DigestAsHex((salt+pwd+salt).getBytes()).toUpperCase();
        }
        return pwd;
    }

    @Override
    public void reg(User user) {
        //找出一个用户对象
        User result = userMapper.findByUsername(user.getUsername());
        if (result != null) {
            throw new UsernameDuplicatedException("用户名已注册");
        }

        //补全数据
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(new Date());
        //密码加密
        //salt+pwd+salt md5加密
        String plainPwd = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        String md5Pwd=getMD5Pwd(plainPwd,salt);
        user.setPassword(md5Pwd);

        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("注册时异常");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        if(result== null){
            throw new UserNotFoundException("用户不存在");
        }
        String salt = result.getSalt();
        String md5Pwd= getMD5Pwd(password,salt);
        if (!md5Pwd.equals(result.getPassword())) {
            throw new PasswordNotMatchException("密码错误");
        }
        if(result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据被删除");
        }
        //返回部分用户数据,只辅助其他页面的数据展示
        User user =new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }
}
