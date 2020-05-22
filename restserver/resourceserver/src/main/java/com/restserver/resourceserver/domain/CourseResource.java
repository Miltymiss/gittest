package com.restserver.resourceserver.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseResource implements Serializable {
    private String resourceId;
    private String resourceName;
    private int resourceType;
    private String url;
    private String courseId;
    private boolean local;
}
