package com.aeroband.datamanage.mapper;

import com.aeroband.datamanage.domain.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where userId=#{userId,mode=IN,jdbcType=VARCHAR}")
    @Results({
            @Result(property = "userId",column = "userId"),
            @Result(property = "password",column = "password")
    })
    UserInfo getUserById(@Param("userId")String userId);
    @Select("select * from user_info where userId=#{userId,mode=IN,jdbcType=VARCHAR} and password=#{password,mode=IN,jdbcType=VARCHAR}")
    @Results({
            @Result(property = "userId",column = "userId"),
            @Result(property = "password",column = "password")
    })
    UserInfo getUserByIdAndPassword(@Param("userId")String userId,@Param("password") String password);

}
