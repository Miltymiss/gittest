package com.restserver.resourceserver.mapper;

import org.apache.ibatis.annotations.*;


@Mapper
public interface CourseUserMapper {
    @Insert("insert into ")
    int insert(@Param("userId")String userId, @Param("courseId") String courseId);
}
