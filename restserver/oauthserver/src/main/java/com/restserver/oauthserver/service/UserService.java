package com.restserver.oauthserver.service;

import com.restserver.oauthserver.domain.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo getUserInfoById(String userId);
    List<UserInfo> getAllUser();
}
