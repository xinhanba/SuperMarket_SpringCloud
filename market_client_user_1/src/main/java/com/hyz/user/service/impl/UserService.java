package com.hyz.user.service.impl;

import com.hyz.market.domain.entity.ConsumerUser;
import com.hyz.user.common.MD5Service;
import com.hyz.user.domain.dao.IUserDao;
import com.hyz.user.exception.ServiceException;
import com.hyz.user.exception.code.ExceptionCode;
import com.hyz.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public ConsumerUser searchUser(String userEmail, String pwd) throws ServiceException {
        ConsumerUser userInfo = userDao.checkUserEmail(userEmail);
        if (userInfo == null) {
            throw new ServiceException(ExceptionCode.INP_00101, "不存在该用户！", false);
        }
        if (userInfo.getF_user_state() != 1) {
            throw new ServiceException(ExceptionCode.INP_00101, "该用户无效，或已被冻结！", false);
        }
        String password = MD5Service.encryptPwd(pwd, userInfo.getF_user_salt());
        if (!userInfo.getF_user_pwd().equals(password)) {
            throw new ServiceException(ExceptionCode.INP_00101, "用户名或密码错误，请检查后重试！", false);
        }
        return userInfo;
    }

}
