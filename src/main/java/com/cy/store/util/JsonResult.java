package com.cy.store.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 状态码
 * 信息
 * 数据
 */

@Data
public class JsonResult <E>implements Serializable {
    private Integer state;
    private String message;
    private E data;

    public JsonResult(){
    }

    public JsonResult(Integer state){
        this.state = state;
    }

    public JsonResult(Throwable e){
        this.message =e.getMessage();
    }//异常的捕获

    public JsonResult(Integer state,E data){
        this.state= state;
        this.data = data;
    }

}
