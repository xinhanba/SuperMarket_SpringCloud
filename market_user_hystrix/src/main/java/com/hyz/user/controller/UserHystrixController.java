package com.hyz.user.controller;

import com.hyz.market.domain.entity.ConsumerUser;
import com.hyz.user.service.IUserFeignService;
import com.hyz.user.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserHystrixController {

    @Resource
    private IUserService userService;
    @Resource
    private IUserFeignService userFeignService;

    @RequestMapping(value = "/hystrix/getUser", method = RequestMethod.GET)
    public ConsumerUser getUser(String email, String pwd) {
        System.out.println("----------" + email + ", " + pwd);
        return userService.getUser(email, pwd);
    }

    @RequestMapping(value = "/hystrix/getConsumerUser", method = RequestMethod.GET)
    public ConsumerUser getConsumerUser(String email, String pwd) {
        System.out.println("----------" + email + ", " + pwd);
        return userFeignService.getUser(email, pwd);
    }

    @RequestMapping(value = "/hystrix/getConsumerUser2", method = RequestMethod.GET)
    public ConsumerUser getConsumerUser2(String email, String pwd) {
        System.out.println("----------" + email + ", " + pwd);
        return userFeignService.getUser2(email, pwd);
    }

}
