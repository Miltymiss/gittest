package com.restserver.resourceserver.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO <T>{
    //状态码 错误码
    private Integer code;
    //提示信息
    private String message="";
    //数据
    private T data;

}
