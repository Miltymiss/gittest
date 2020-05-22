package com.restserver.resourceserver.service.iplm;

import com.restserver.resourceserver.domain.CourseResource;
import com.restserver.resourceserver.mapper.CourseResourcesMapper;
import com.restserver.resourceserver.service.CourseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseResourceServiceIplm implements CourseResourceService {
    @Autowired
    private CourseResourcesMapper  mapper;

    @Override
    @Cacheable(value="allResources",key="#courseId",unless = "#result.size()==0")
    public List<CourseResource> getListByCourseId(String courseId) {
        return mapper.getListById(courseId);
    }

    @Override
    @Cacheable(value="resource",key="#resourceId")
    public CourseResource getResourceByResourceId(String resourceId) {
        return mapper.getById(resourceId);
    }
}
