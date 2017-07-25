package com.utsoft.blockchain.api.util;
import java.io.Serializable;

import com.utsoft.blockchain.support.util.ConstantUtil;
/**
 * 统一返回处理
 * @author <a href="flyskyhunter@gmail.com">王波</a> 
 * @date  2017年7月17日
 * @version 1.0
 * @param <T>
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 3771700626958736013L;
    private int code;
    private String message;
    private T data;
    private long timestamp = System.currentTimeMillis();

    private BaseResponse() {
        code = ConstantUtil.OK;
    }

    private BaseResponse(String message) {
        this();
        this.message = message;
    }
    
    private BaseResponse(int code) {
        this();
        this.code = code;
    }

    private BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;

    }

    private BaseResponse(T t) {
        this();
        data = t;
    }
    
    public boolean isSuccess() {
        return this.code == ConstantUtil.OK;
    }
    
    public static <T> BaseResponse<T> build() {
    	return new BaseResponse<>();
    }
    
    public static <T> BaseResponse<T> build(int code) {
    	return new BaseResponse<>(code);
    }
    
    public static <T> BaseResponse<T> build(int code, String message) {
    	return new BaseResponse<>(code, message);
    }
    
    public static <T> BaseResponse<T> build(T data) {
    	return new BaseResponse<>(data);
    }
    
    public static <T> BaseResponse<T> build(String message) {
    	return new BaseResponse<>(message);
    }

	public int getCode() {
		return code;
	}

	public BaseResponse<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public BaseResponse<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public BaseResponse<T> setData(T data) {
		this.data = data;
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}