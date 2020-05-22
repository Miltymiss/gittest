package com.restserver.resourceserver.service.iplm;

import com.restserver.resourceserver.domain.CourseType;
import com.restserver.resourceserver.mapper.CourseTypeMapper;
import com.restserver.resourceserver.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseTypeServiceIplm implements CourseTypeService {
    @Autowired
    private CourseTypeMapper mapper;
    @Override
    @Cacheable(value="typeInfo",key="#CourseType")
    public CourseType getTypeInfoById(Integer CourseType) {
        return mapper.getById(CourseType);
    }
    @Cacheable(value="allType",unless = "#result.size()==0")
    @Override
    public List<CourseType> getTypeList() {
        return mapper.getTypeList();
    }
}