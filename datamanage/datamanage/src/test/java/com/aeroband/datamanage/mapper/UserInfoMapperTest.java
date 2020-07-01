package com.aeroband.datamanage.mapper;

import com.aeroband.datamanage.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper mapper;
    @Test
    public void mapperTest(){
        UserInfo userInfo=mapper.getUserByIdAndPassword("123456","1111111");
        System.out.println(userInfo);
    }
}