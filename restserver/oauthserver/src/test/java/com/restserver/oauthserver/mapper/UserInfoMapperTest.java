package com.restserver.oauthserver.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper mapper;

    @Test
    public void test(){
        mapper.getAll();
    }
}