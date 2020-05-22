package com.restserver.resourceserver.mapper;

import com.restserver.resourceserver.domain.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from course_info where course_type=#{typeId,mode=IN,jdbcType=INTEGER}")
    @Results({@Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "courseType",column = "course_type"),
            })
    List<Course> getCourseListByType(@Param("typeId") Integer typeId);


    @Select("select * from course_info where course_id=#{courseId,mode=IN,jdbcType=VARCHAR}")
    @Results({@Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "courseType",column = "course_type"),
    })
    Course getById(@Param("courseId") String courseId);

    @Select("select * from course_info")
    @Results({@Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "courseType",column = "course_type"),
    })
    List<Course> getAll();
    @Select("select * from course_info where course_name like '%${value}%'")
    @Results({@Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "courseType",column = "course_type"),
    })
    List<Course> getListByKeyWord(String keyWord);


}
