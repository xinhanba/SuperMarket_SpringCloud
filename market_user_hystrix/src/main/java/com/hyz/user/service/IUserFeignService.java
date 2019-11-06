package com.hyz.user.service;

import com.hyz.user.domain.entity.ConsumerUser;
import com.hyz.user.service.impl.FallBackUserFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-client-user", fallback = FallBackUserFactory.class)
public interface IUserFeignService {

    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
    ConsumerUser getUser(@RequestParam(value = "email") String email, @RequestParam(value = "pwd") String pwd);

    @RequestMapping(value = "/user/getUser2", method = RequestMethod.GET)
    ConsumerUser getUser2(@RequestParam(value = "email") String email, @RequestParam(value = "pwd") String pwd);


}
