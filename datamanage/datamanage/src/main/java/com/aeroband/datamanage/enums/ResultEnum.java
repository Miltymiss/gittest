package com.aeroband.datamanage.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    USER_NOT_EXIST(0,"用户不存在");

    private Integer code;
    private String message;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.message=msg;
    }
}
