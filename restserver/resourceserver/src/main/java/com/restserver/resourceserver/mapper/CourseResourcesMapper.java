package com.restserver.resourceserver.mapper;

import com.restserver.resourceserver.domain.CourseResource;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface CourseResourcesMapper {
    @Select("select * from course_resource where course_id=#{courseId,mode=IN,jdbcType=VARCHAR}")
    @Results({@Result(property = "courseId",column = "course_id"),
            @Result(property = "resourceName",column ="resource_name" ),
            @Result(property = "url",column = "resource_url"),
            @Result(property = "resourceType",column = "type"),
            @Result(property = "local",column ="local" )})
    List<CourseResource> getListById(@Param("courseId") String courseId);


    @Select("select * from course_resource where resource_id=#{resourceId,mode=IN,jdbcType=VARCHAR}")
    @Results({@Result(property = "courseId",column = "course_id"),
            @Result(property = "resourceName",column ="resource_name" ),
            @Result(property = "url",column = "resource_url"),
            @Result(property = "resourceType",column = "type"),
            @Result(property = "local",column ="local" )})
    CourseResource getById(@Param("resourceId") String resourceId);
}
