package com.restserver.oauthserver.service;

import com.restserver.oauthserver.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleListByUserId(String userId);
}
