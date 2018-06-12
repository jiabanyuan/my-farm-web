package com.model;



import com.enums.ReturnValueEnum;
import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

/**
 * controller返回值
 */
public class ReturnValue implements Serializable {

    private static final long serialVersionUID = 1L;
    /**返回状态码*/
	public static final int ERROR = -1;
	public static final int FAILED = 0;
	public static final int SUCCESS = 1;

	public static final String KEY_CODE = "code";
	public static final String KEY_MSG = "message";

	/**状态码*/
	private Integer code;

	/**消息*/
	private String message;

	/**数据*/
	private HashMap<String, Object> map;

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

    /**构造方法*/
	public ReturnValue() {}

	public ReturnValue(ReturnValueEnum returnValueEnum){
		this.code = returnValueEnum.getCode();
		this.message = returnValueEnum.getMessage();
	}

	public ReturnValue(ReturnValueEnum returnValueEnum, String message){
		this.code = returnValueEnum.getCode();
		this.message = message;
	}

	/**
	 * 设置结果数据
     * @param key
	 * @param data
	 */
	public void put(String key, Object data) {
		if (map == null) {
			map = new HashMap<String,Object>();
		}
		map.put(key, data);
	}

	/**
	 * 获取结果数据
	 * @param key
	 */
	public Object get(String key) {
		if(map == null) 
			return null;
		return map.get(key);
	}
	
	public String toString() {
		JSONObject json = new JSONObject();
		json.put(KEY_CODE, code);
		json.put(KEY_MSG, message);
		if (map != null) {
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				json.put(key, map.get(key));
			}
		}
		return json.toString();
	}

	public String toString(int code, String message) {
		JSONObject json = new JSONObject();
		json.put(KEY_CODE, code);
		json.put(KEY_MSG, message);
		if (map != null) {
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				json.put(key, map.get(key));
			}
		}
		return json.toString();
	}
}
