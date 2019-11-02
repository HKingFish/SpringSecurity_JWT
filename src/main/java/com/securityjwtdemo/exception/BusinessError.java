package com.securityjwtdemo.exception;
import com.securityjwtdemo.common.I18NMessage;

/**
 * 业务异常
 */
public class BusinessError extends SystemException {
	private static final long serialVersionUID = 1L;


	public BusinessError(String key, String message) {
		super(key,message);
	}

	public BusinessError(String message) {
		super("",message);
	}

	public BusinessError(String key, Throwable e) {
		super(key,e);
	}

	public BusinessError(String key, String[] args) {
		super(key,args);
	}

	public BusinessError(String key, String[] args, Throwable e) {
		super(key,args,e);
	}

	public BusinessError(String key, I18NMessage[] i18nArgs) {
		super(key,i18nArgs);
	}

	public BusinessError(String key, I18NMessage[] i18nArgs, Throwable e) {
		super(key,i18nArgs,e);
	}

	public String getKey() {
		return this.getI18NMessage().getKey();
	}
	public String getMessage() {
		return this.getI18NMessage().getMessage();
	}
}
