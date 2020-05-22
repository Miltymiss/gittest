package com.restserver.oauthserver.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfo implements Serializable {
    private String userId;
    private String password;
    private List<Role> role;
}
