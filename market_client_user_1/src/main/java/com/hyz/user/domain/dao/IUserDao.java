package com.hyz.user.domain.dao;

import com.hyz.user.domain.entity.ConsumerUser;

public interface IUserDao {

    ConsumerUser checkUserEmail(String userEmail);

}
