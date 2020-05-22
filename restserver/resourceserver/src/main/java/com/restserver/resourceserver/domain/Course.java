package com.restserver.resourceserver.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
@Data
public class Course  implements Serializable {
    private String courseId;
    private String courseName;
    private int courseType;
    private List<CourseResource> resources;
    private String description;
}
