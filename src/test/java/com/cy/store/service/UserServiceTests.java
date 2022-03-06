package com.cy.store.service;


import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private UserSerivce userSerivce;

    @Test
    public void reg(){
        try {
            User user= new User();
            user.setUsername("lilmi");
            user.setPassword("123");
            userSerivce.reg(user);
            System.err.println("ok");
        } catch (ServiceException e) {
            System.err.println(e.getClass());//获取异常类名称
            System.err.println(e.getMessage());//获取异常类信息
        }
    }

    @Test
    public void login(){
        User user = userSerivce.login("test001","123");
        System.out.println(user);
    }
}
