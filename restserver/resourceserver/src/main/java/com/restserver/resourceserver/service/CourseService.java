package com.restserver.resourceserver.service;

import com.restserver.resourceserver.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseListByType(Integer typeId);
    List<Course> getAllCourse();
    Course getById(String courseId);
}
