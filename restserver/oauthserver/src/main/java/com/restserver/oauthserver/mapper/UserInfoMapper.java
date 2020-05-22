package com.restserver.oauthserver.mapper;

import com.restserver.oauthserver.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_id=#{userId,mode=IN,jdbcType=VARCHAR}")
    @Results({@Result(property = "userId",column = "user_id"),@Result(property = "password",column = "password")})
    UserInfo getById(@Param("userId")String userId);

    @Select("select * from user_info")
    @Results({@Result(property = "userId",column = "user_id"),@Result(property = "password",column = "password")})
    List<UserInfo> getAll();
}
