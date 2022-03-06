package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//启动单元测试类
@RunWith(SpringRunner.class)
public class UserMapperTests {
//接口是不能直接创建Bean对象的
    //Inspections(检查) - Spring - Spring Core - Code - Autowiring for bean class
    @Autowired
    private UserMapper userMapper;
    /**
     * SpringBootTest
     * RunWith
     * Test
     * void
     * public
     */
    @Test
    public void insert(){
        User user= new User();
        user.setUsername("lilming");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);//插入的行数
        System.err.println(rows);
    }
    @Test
    public void findByUsername(){

//        User user=userMapper.findByUsername("lilming");
        System.err.println(userMapper.findByUsername("lilming"));
    }
}
