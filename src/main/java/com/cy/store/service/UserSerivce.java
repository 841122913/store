package com.cy.store.service;

import com.cy.store.entity.User;

/**
 * 业务service层，给controller层的类提供接口进行调用。
 * 一般就是自己写的方法封装起来，就是声明一下，具体实现在serviceImpl中。
 */
public interface UserSerivce {
    /**
     * 用户注册，名称自定义不同于mapper层
     * @param user 用户数据对象
     */
    void reg(User user);

    User login(String username,String password);
}
