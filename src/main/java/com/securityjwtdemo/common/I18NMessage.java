package com.securityjwtdemo.common;

import java.io.Serializable;

public class I18NMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String key;
	private String[] args;
	private I18NMessage[] i18nArgs;

	public I18NMessage(String message) {
		this.message = message;
	}
	public I18NMessage(String key, String message) {
		this.key=key;
		this.message = message;
	}
	public I18NMessage(String key, String[] args) {
		this.key=key;
		this.args = args;
	}
	public I18NMessage(String key, I18NMessage[] i18nArgs) {
		this.key=key;
		this.i18nArgs = i18nArgs;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String[] getArgs() {
		return args;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setI18nArgs(I18NMessage[] i18nArgs) {
		this.i18nArgs = i18nArgs;
	}
	public I18NMessage[] getI18nArgs() {
		return i18nArgs;
	}

}
