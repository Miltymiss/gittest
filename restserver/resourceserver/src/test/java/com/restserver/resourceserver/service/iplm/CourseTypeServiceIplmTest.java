package com.restserver.resourceserver.service.iplm;

import com.restserver.resourceserver.domain.CourseType;
import com.restserver.resourceserver.service.CourseTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseTypeServiceIplmTest {
    @Autowired
    private CourseTypeService service;
    @Test
    public void test(){
        CourseType courseType=service.getTypeInfoById(10000000);
        System.out.println(courseType);
    }
}