package com.restserver.resourceserver.service;

import com.restserver.resourceserver.domain.CourseResource;

import java.util.List;

public interface CourseResourceService {
    List<CourseResource> getListByCourseId(String courseId);
    CourseResource getResourceByResourceId(String resourceId);

}
