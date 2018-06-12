package com.enums;

/**
 * 返回值枚举类，message字段请根据实际情况复写
 * @author wuwenchao
 *
 */
public enum ReturnValueEnum {

	ERROR(-1, "操作错误"),
	FAILED(0, "操作失败"),
	SUCCESS(1, "操作成功"),
	;

	/**状态码*/
	private int code;

	/**消息*/
	private String message;
	
	ReturnValueEnum(int code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
