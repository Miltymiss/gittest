package com.aeroband.datamanage.serviceimpl;

import com.aeroband.datamanage.domain.UserInfo;
import com.aeroband.datamanage.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void test(){
        UserInfo userInfo=userService.getUserById("123456");
        System.out.println(userInfo);
    }
}