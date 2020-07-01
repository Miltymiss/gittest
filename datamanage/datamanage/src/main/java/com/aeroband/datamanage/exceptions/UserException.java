package com.aeroband.datamanage.exceptions;

import com.aeroband.datamanage.enums.ResultEnum;
import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private Integer code;
    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

}
