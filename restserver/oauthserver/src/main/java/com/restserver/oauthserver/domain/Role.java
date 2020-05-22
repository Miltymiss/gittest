package com.restserver.oauthserver.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private String courseId;
}
