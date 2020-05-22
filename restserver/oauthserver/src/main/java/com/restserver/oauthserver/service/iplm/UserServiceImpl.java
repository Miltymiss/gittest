package com.restserver.oauthserver.service.iplm;

import com.restserver.oauthserver.domain.UserInfo;
import com.restserver.oauthserver.mapper.UserInfoMapper;
import com.restserver.oauthserver.service.RoleService;
import com.restserver.oauthserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper mapper;
    @Autowired
    private RoleService service;
    @Override
    public UserInfo getUserInfoById(String userId) {
        UserInfo userInfo=mapper.getById(userId);
        userInfo.setRole(service.getRoleListByUserId(userId));
        return userInfo;
    }

    @Override
    public List<UserInfo> getAllUser() {
        return mapper.getAll();
    }
}
