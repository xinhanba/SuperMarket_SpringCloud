package com.hyz.user.service.impl;

import com.hyz.user.domain.entity.ConsumerUser;
import com.hyz.user.service.IUserFeignService;
import org.springframework.stereotype.Component;

@Component
public class FallBackUserFactory implements IUserFeignService {

    @Override
    public ConsumerUser getUser(String email, String pwd) {
        System.out.println("进入fallBack1方法：" + email + ", " + pwd);
        ConsumerUser user = new ConsumerUser();
        user.setF_user_id("-1L");
        user.setF_user_email("错误信息~~~~1111");
        return user;
    }

    @Override
    public ConsumerUser getUser2(String email, String pwd) {
        System.out.println("进入fallBack2方法：" + email + ", " + pwd);
        ConsumerUser user = new ConsumerUser();
        user.setF_user_id("-1L");
        user.setF_user_email("错误信息~~~~22222");
        return user;
    }

}
