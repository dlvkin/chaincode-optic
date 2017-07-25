package com.utsoft.blockchain.support.util;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/**
 * 全局变量
 * @author hunterfox
 * @date 2017年7月17日
 */
public class ConstantUtil {

	 public final static int OK = 200;
	 public final static int ITEM_NOT_FIND = 404;
	 public final static int SEVER_INNER_ERROR = 500;
	 public final static int BAD_REQUEST = 400;
	 public final static int METHOD_NOT_ALLOW = 405;
	 public final static int MEDIA_NOT_SUPPORT = 415;
	 public final static String PIC_INTERVAL_SYMBOL ="||";
	 
	 /**
	  * 时间区域
	  */
	 public final static ZoneId ZONEID = ZoneId.systemDefault();
	 public final static DateTimeFormatter DAREFORMATTER =DateTimeFormatter.ofPattern("yyyy年MM月dd日");
}
