package com.securityjwtdemo.exception;

import com.securityjwtdemo.common.I18NMessage;

/**
 * @Author : KingFish
 * @Email : XXXXXX
 * @Data: 2019/8/27
 * @Des:  登录失效异常
 */
public class LoginInvalidationException extends BusinessError {
    public LoginInvalidationException(String key, String message) {
        super(key, message);
    }

    public LoginInvalidationException(String message) {
        super(message);
    }

    public LoginInvalidationException(String key, Throwable e) {
        super(key, e);
    }

    public LoginInvalidationException(String key, String[] args) {
        super(key, args);
    }

    public LoginInvalidationException(String key, String[] args, Throwable e) {
        super(key, args, e);
    }

    public LoginInvalidationException(String key, I18NMessage[] i18nArgs) {
        super(key, i18nArgs);
    }

    public LoginInvalidationException(String key, I18NMessage[] i18nArgs, Throwable e) {
        super(key, i18nArgs, e);
    }

}