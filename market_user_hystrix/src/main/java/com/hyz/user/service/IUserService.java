package com.hyz.user.service;

import com.hyz.user.domain.entity.ConsumerUser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(value = "eureka-client-user")
public interface IUserService {

//    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "")
    ConsumerUser getUser(String email, String pwd);

}
