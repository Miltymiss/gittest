package com.aeroband.datamanage.service;

import com.aeroband.datamanage.domain.UserInfo;

public interface UserService {
    UserInfo getUserById(String userId);
}
