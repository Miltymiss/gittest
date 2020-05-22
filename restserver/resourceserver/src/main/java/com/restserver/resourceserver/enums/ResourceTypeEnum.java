package com.restserver.resourceserver.enums;

import lombok.Getter;

@Getter
public enum ResourceTypeEnum {
    DOC(0,"文档"),
    VIDEO(1,"视频"),
    IMAGE(2,"图片");
    private Integer code;
    private String msg;

    ResourceTypeEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
