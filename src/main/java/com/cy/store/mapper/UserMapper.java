package com.cy.store.mapper;

import com.cy.store.entity.User;

/**
 * 用户持久层
 * mapper层
 * 别名： dao层
 * 用途： 对数据库进行数据持久化操作
 * 他的方法语句是直接针对数据库操作的
 * 主要实现一些增删改查操作
 * 在mybatis中方法主要与与xxx.xml内相互一一映射。
 */
public interface UserMapper {
    /**
     * 注册，插入用户数据
     * @param user 一个用户的数据
     * @return 受到影响的行数
     */

    Integer insert(User user);//对应<insert id="insert ">

    /**
     * 根据用户名来查询用户数据，username为本接口内自定义的一个参数
     * @param username 用户名
     * @return 找到返回用户对象数据，反之返回null
     */
    User findByUsername(String username);//对应<select id="findByUsername">


}
