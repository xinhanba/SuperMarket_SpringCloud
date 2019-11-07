package com.hyz.user.domain.dao;

import com.hyz.market.domain.entity.ConsumerUser;

public interface IUserDao {

    ConsumerUser checkUserEmail(String userEmail);

}
