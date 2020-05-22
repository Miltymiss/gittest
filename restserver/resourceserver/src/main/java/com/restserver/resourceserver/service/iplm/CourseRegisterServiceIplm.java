package com.restserver.resourceserver.service.iplm;

import com.restserver.resourceserver.mapper.CourseUserMapper;
import com.restserver.resourceserver.service.CourseRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegisterServiceIplm implements CourseRegisterService {
    @Autowired
    private CourseUserMapper mapper;
    @Override
    public int register(String courseId, String userId) {
        return mapper.insert(userId,courseId);
    }
}
