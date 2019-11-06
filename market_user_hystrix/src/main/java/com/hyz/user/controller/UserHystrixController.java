package com.hyz.user.controller;

import com.hyz.user.domain.entity.ConsumerUser;
import com.hyz.user.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserHystrixController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/hystrix/getUser", method = RequestMethod.GET)
    public ConsumerUser getUser(String email, String pwd) {
        System.out.println("----------" + email + ", " + pwd);
        return userService.getUser(email, pwd);
    }

}
