package com.hyz.user.common;

import com.hyz.user.exception.ServiceException;
import com.hyz.user.exception.code.ExceptionCode;
import com.hyz.user.utils.MD5Utils;

public class MD5Service {

    /**
     * 加密用户的登录密码
     *
     * @param pwd
     *            登录密码
     * @param salt
     *            随机码
     * @return
     * @throws Exception
     */
    public static String encryptPwd(String pwd, String salt) throws ServiceException {
        try {
            pwd = MD5Utils.encryptString(pwd).toLowerCase() + salt;
            pwd = MD5Utils.encryptString(pwd).toLowerCase();
        } catch (Exception e) {
            throw new ServiceException(ExceptionCode.INP_00101, "加密用户的登录密码异常，请检查密码是否为空！", false);
        }

        return pwd;
    }

    public static void main(String[] args) throws ServiceException {
        String str = encryptPwd("123456", "kyx456");
        System.out.println(str);
    }

    /**
     * 加密用户的交易密码
     *
     * @param payword
     *            交易密码
     * @param random
     *            交易随机码
     * @return
     * @throws Exception
     */
    public static String encryptPayword(String payword, String random) throws ServiceException {
        try {
            payword = MD5Utils.encryptString(payword + random.toLowerCase()).toLowerCase();
            payword = MD5Utils.encryptString(payword).toLowerCase();
        } catch (Exception e) {
            throw new ServiceException(ExceptionCode.INP_00101, "加密用户的交易密码异常，请检查密码是否为空！", false);
        }
        return payword;
    }

}
