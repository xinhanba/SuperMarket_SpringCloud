package com.hyz.user.controller;

import com.hyz.user.domain.entity.ConsumerUser;
import com.hyz.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserFeignController {

    @Resource
    private IUserService userService;

    @GetMapping(value = "feign/getUser")
    public ConsumerUser getUser(String email, String pwd) {
         return userService.getUser(email, pwd);
    }

    @GetMapping(value = "feign/getConsumerUser")
    public ConsumerUser getConsumerUser(ConsumerUser consumerUser) {
        return userService.getConsumerUser(consumerUser);
    }

}
