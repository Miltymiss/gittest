package com.restserver.resourceserver.service.iplm;

import com.restserver.resourceserver.domain.Course;
import com.restserver.resourceserver.mapper.CourseMapper;
import com.restserver.resourceserver.service.CourseResourceService;
import com.restserver.resourceserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceIplm implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseResourceService courseResourceService;
    @Override
    @Cacheable(value="allCourses",key="#typeId",unless = "#result.size()==0")
    public List<Course> getCourseListByType(Integer typeId) {
        return courseMapper.getCourseListByType(typeId);
    }

    @Override
    public List<Course> getAllCourse() {
        return getResource(courseMapper.getAll());
    }
    @Cacheable(value="course",key="#courseId")
    @Override
    public Course getById(String courseId) {
        return courseMapper.getById(courseId);
    }

    private List<Course> getResource(List<Course> courseList){
        for(Course course:courseList){
            course.setResources(courseResourceService.getListByCourseId(course.getCourseId()));
        }
        return courseList;
    }
}
