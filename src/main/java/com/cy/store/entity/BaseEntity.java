package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data// 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
/**
 * 用户实体类公共字段
 *
 */
public class BaseEntity implements Serializable {

    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
