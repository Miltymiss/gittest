package com.aeroband.datamanage.serviceimpl;

import com.aeroband.datamanage.domain.UserInfo;
import com.aeroband.datamanage.enums.ResultEnum;
import com.aeroband.datamanage.exceptions.UserException;
import com.aeroband.datamanage.mapper.UserInfoMapper;
import com.aeroband.datamanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper mapper;
    @Override
    public UserInfo getUserById(String userId) {
        UserInfo userInfo=mapper.getUserById(userId);
        if(userInfo==null){
            throw new UserException(ResultEnum.USER_NOT_EXIST);
        }
        return userInfo;
    }
}
