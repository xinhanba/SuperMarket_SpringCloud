package com.hyz.user.service;

import com.hyz.market.domain.entity.ConsumerUser;

public interface IUserService {

    ConsumerUser getUser(String email, String pwd);

}
