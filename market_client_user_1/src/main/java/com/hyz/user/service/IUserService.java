package com.hyz.user.service;

import com.hyz.market.domain.entity.ConsumerUser;
import com.hyz.user.exception.ServiceException;

public interface IUserService {

    public ConsumerUser searchUser(String userName, String pwd) throws ServiceException;

}
