package com.aeroband.datamanage.controller;

import com.aeroband.datamanage.domain.UserInfo;
import com.aeroband.datamanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/aeroband/permission")
public class PermissionController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model m, UserInfo userInfo, BindingResult bindingResult, HttpServletResponse servletResponse){
        try {
            UserInfo userInfo1 = userService.getUserById(userInfo.getUserId());
        }catch (Exception e){
            return null;
        }
        return null;
    }

}
