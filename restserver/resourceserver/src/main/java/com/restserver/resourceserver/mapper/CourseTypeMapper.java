package com.restserver.resourceserver.mapper;

import com.restserver.resourceserver.domain.CourseType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseTypeMapper {
    @Select("Select * from course_type where type_id=#{typeId,mode=IN,jdbcType=INTEGER}")
    @Results({@Result(property= "typeId",column = "type_id"),
            @Result(property = "typeName",column = "type_name"),
            @Result(property = "description",column = "description")})
    CourseType getById(@Param("typeId") Integer typeId);
    @Select("Select * from course_type")
    @Results({@Result(property= "typeId",column = "type_id"),
            @Result(property = "typeName",column = "type_name"),
            @Result(property = "description",column = "description")})
    List<CourseType> getTypeList();
}
