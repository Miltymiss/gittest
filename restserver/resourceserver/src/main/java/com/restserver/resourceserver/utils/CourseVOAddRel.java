package com.restserver.resourceserver.utils;

import com.restserver.resourceserver.controller.CourseController;

import com.restserver.resourceserver.vo.CourseList;
import com.restserver.resourceserver.vo.CourseVO;
import org.springframework.http.HttpHeaders;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class CourseVOAddRel {
    public static CourseList addRel(CourseList courseVOList,HttpHeaders headers) throws Exception {
        List<CourseVO> courseVOS=courseVOList.getCourseVOList();
        for (CourseVO courseVO : courseVOS) {
            courseVOList.add(linkTo(methodOn(CourseController.class).getDetail(courseVO.getCourseId(),headers)).withRel("get_detail"+courseVO.getCourseName()));
        }
        courseVOList.setCourseVOList(courseVOS);
        courseVOList.add(linkTo(methodOn(CourseController.class).courseVOList(courseVOS.get(0).getCourseType(),headers)).withSelfRel());
        return courseVOList;
    }
}
