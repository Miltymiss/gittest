package com.restserver.resourceserver.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restserver.resourceserver.domain.Course;
import com.restserver.resourceserver.domain.CourseResource;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class CourseVO extends RepresentationModel<CourseVO> {
    @JsonProperty("courseId")
    private String courseId;
    @JsonProperty("courseName")
    private String courseName;
    @JsonProperty("courseType")
    private String typeName;
    @JsonProperty("typeId")
    private int courseType;
}
