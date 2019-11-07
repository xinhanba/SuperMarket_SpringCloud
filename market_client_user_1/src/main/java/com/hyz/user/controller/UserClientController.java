package com.hyz.user.controller;

import com.hyz.market.domain.entity.ConsumerUser;
import com.hyz.user.exception.ServiceException;
import com.hyz.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserClientController {

    @Resource
    private IUserService userService;

    @GetMapping(value = "/getUser")
    public ConsumerUser getUser(String email, String pwd) throws ServiceException {
        return userService.searchUser(email, pwd);
    }

    @GetMapping(value = "/getUser2")
    public ConsumerUser getUser2(String email, String pwd) throws ServiceException {
        return userService.searchUser(email, pwd);
    }

    @GetMapping(value = "/getConsumerUser")
    public ConsumerUser getUser(@RequestBody ConsumerUser consumerUser) throws ServiceException {
        return userService.searchUser(consumerUser.getF_user_email(), consumerUser.getF_user_pwd());
    }

}
