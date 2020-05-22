package com.restserver.oauthserver.mapper;

import com.restserver.oauthserver.domain.Role;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface CourseUserMapper {
    @Select("select course_id from course_user where status=1 and user_id=#{userId,mode=IN,jdbcType=VARCHAR}")
    @Results({@Result(property = "courseId",column = "course_id")})
    List<Role> getRoleByUserId(@Param("userId")String  userId);
}
