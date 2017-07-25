package com.utsoft.blockchain.support.util;
/**
 * 服务器异常
 * @author <a href="flyskyhunter@gmail.com">王波</a> 
 * @date  2017年7月6日
 * @version 1.0
 */
public class ServiceProcessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceProcessException(String message) {
		super(message);
	}

	public static ServiceProcessException build(String msg) {
		return  new ServiceProcessException(msg);
	}
	
}
