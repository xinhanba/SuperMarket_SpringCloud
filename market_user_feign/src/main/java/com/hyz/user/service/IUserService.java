package com.hyz.user.service;

import com.hyz.market.domain.entity.ConsumerUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("eureka-client-user")
public interface IUserService {

    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
    ConsumerUser getUser(@RequestParam(value = "email") String email, @RequestParam(value = "pwd") String pwd);


    @RequestMapping(value = "/user/getConsumerUser", method = RequestMethod.POST)
    ConsumerUser getConsumerUser(@RequestBody ConsumerUser consumerUser);

}
