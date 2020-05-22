package com.restserver.resourceserver.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restserver.resourceserver.domain.CourseResource;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
@Data
public class CourseDetailVO extends RepresentationModel<CourseList> {
    @JsonProperty("courseId")
    private String courseId;
    @JsonProperty("courseName")
    private String courseName;
    @JsonProperty("courseType")
    private String typeName;
    @JsonProperty("typeId")
    private int courseType;
    @JsonProperty("resources")
    private List<CourseResource> resources;
    @JsonProperty("description")
    private String description;
}
