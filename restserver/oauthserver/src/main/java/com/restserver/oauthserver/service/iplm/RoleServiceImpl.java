package com.restserver.oauthserver.service.iplm;

import com.restserver.oauthserver.domain.Role;
import com.restserver.oauthserver.mapper.CourseUserMapper;
import com.restserver.oauthserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private CourseUserMapper mapper;
    @Override
    public List<Role> getRoleListByUserId(String userId) {
        return mapper.getRoleByUserId(userId);
    }
}
