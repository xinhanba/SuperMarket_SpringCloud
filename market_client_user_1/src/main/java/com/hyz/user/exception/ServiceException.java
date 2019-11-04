package com.hyz.user.exception;

import com.hyz.user.exception.code.ExceptionCode;
import org.springframework.util.StringUtils;

/**
 * Service层公用的Exception.
 *
 * 继承自Exception, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 */
public class ServiceException extends Exception {

    /**
     * 异常错误码
     * Default Value is Undefined Exception
     */
    private String code;

    /**
     * 异常信息， 此信息经过封装，展现给用户
     */
    private String errorMessage;

    public String getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 异常抛出信息系统根据异常代码从系统中获取
     * @param code 异常代码
     */
    public ServiceException(String code) {
        setCode(code);
        setErrorMessage(code, "", true);
    }

    /**
     *
     * @param code 异常代码
     * @param message 错误提示消息
     * @param isConvertMsg 错误消息是否需要转换成系统登记消息，如果为是则取系统登记消息显示给用户，如果为否则用当前message显示给用户
     */
    public ServiceException(String code, String message, boolean isConvertMsg) {
        //super(message.concat(" ").concat(ExceptionMessage.getMessage(code)));
        super(message.concat(" "));
        setCode(code);
        setErrorMessage(code, message, isConvertMsg);
    }

    /**
     * 异常抛出信息系统根据异常代码从系统中获取
     * @param code 异常代码
     * @param cause 异常对象
     */
    public ServiceException(String code, Throwable cause) {
        setCode(code);
        setErrorMessage(code, "", true);
    }

    /**
     *
     * @param code 异常代码
     * @param message 错误提示消息
     * @param isConvertMsg 错误消息是否需要转换成系统登记消息，如果为是则取系统登记消息显示给用户，如果为否则用当前message显示给用户
     * @param cause 异常对象
     */
    public ServiceException(String code, String message, boolean isConvertMsg,  Throwable cause) {
        //super(message.concat(" ").concat(ExceptionMessage.getMessage(code)), cause);
        super(message.concat(" ") , cause);
        setCode(code);
        setErrorMessage(code, message, isConvertMsg);
    }

    private void setCode(String code) {
        if (StringUtils.isEmpty(code) || code.length() > 10) {
            code = ExceptionCode.ERR_00000;
        }
        this.code = code;
    }

    private void setErrorMessage(String code, String message, boolean isConvertMsg) {
        //转换Message信息
        if (isConvertMsg) {
            //this.errorMessage = ExceptionMessage.getMessage(code);
        }

        //如果没有登记异常信息且当前程序提示不为空
        if (!isConvertMsg || (this.code.equals(ExceptionCode.ERR_00000) && message.length() > 0)) {
            this.errorMessage = code.concat(": ").concat(message);
        }

    }



}
