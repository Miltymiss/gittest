package com.restserver.resourceserver.utils;

import com.restserver.resourceserver.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVo=new ResultVO();
        resultVo.setCode(0);
        resultVo.setMessage("success");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVO success(){
        return null;
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVo=new ResultVO();
        resultVo.setCode(code);
        resultVo.setMessage(msg);
        return resultVo;

    }
}
