package com.securityjwtdemo.exception;


import com.securityjwtdemo.common.I18NMessage;

/**
 * 系统错误
 */
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private I18NMessage i18NMessage;

	public SystemException() {
	}
	
	public SystemException(String key) {
		setI18NMessage(new I18NMessage(key,(String[])null));
	}
	
	public SystemException(String key, String message) {
		setI18NMessage(new I18NMessage(key,message));
	}
	
	public SystemException(Throwable e) {
		super(e);
	}
	
	public SystemException(String key, Throwable e) {
		super(e);
		setI18NMessage(new I18NMessage(key,(String[])null));
	}
	
	public SystemException(String key, String[] args) {
		setI18NMessage(new I18NMessage(key,args));
	}
	
	public SystemException(String key, String[] args, Throwable e) {
		super(e);
		setI18NMessage(new I18NMessage(key,args));
	}
	
	public SystemException(String key, I18NMessage[] i18nArgs) {
		setI18NMessage(new I18NMessage(key,i18nArgs));
	}
	
	public SystemException(String key, I18NMessage[] i18nArgs, Throwable e) {
		super(e);
		setI18NMessage(new I18NMessage(key,i18nArgs));
	}

	public void setI18NMessage(I18NMessage i18n) {
		this.i18NMessage = i18n;
	}

	public I18NMessage getI18NMessage() {
		return i18NMessage;
	}
	
	
}
