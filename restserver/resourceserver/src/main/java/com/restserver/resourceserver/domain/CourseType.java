package com.restserver.resourceserver.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseType implements Serializable {
    private int typeId;
    private String typeName;
    private String description;
}
