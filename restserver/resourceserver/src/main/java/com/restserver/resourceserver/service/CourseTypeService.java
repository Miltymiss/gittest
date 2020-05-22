package com.restserver.resourceserver.service;

import com.restserver.resourceserver.domain.CourseType;

import java.util.List;

public interface CourseTypeService {
    CourseType getTypeInfoById(Integer CourseType);
    List<CourseType> getTypeList();
}
