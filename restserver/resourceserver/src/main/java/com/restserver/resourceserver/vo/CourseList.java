package com.restserver.resourceserver.vo;

import com.restserver.resourceserver.domain.Course;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
@Data
public class CourseList extends RepresentationModel<CourseList> {
    private List<CourseVO> courseVOList;
    public CourseList(List<CourseVO> courseList){
        courseVOList=courseList;
    }
}
