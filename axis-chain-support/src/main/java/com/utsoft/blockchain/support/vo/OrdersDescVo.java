package com.utsoft.blockchain.support.vo;

import java.io.Serializable;
import java.util.Date;
/**
 * 订单
 * @author hunterfox
 * @date 2017年7月18日
 */
public class OrdersDescVo implements Serializable {

	private static final long serialVersionUID = -2780989918013699161L;

	/**
	 * 交易id
	 */
	int id;
	/**
	 * 交易类型：1-限价买，2-限价卖，3-市价买，4-市价卖
	 */
	private int type;
	/**
	 * 订单价格
	 */
	private double order_price;
	/**
	 * 订单数量
	 */
	private double order_amount;
	/**
	 * 订单发生时间
	 */
	private Date order_time;
	/**
	 * 交易状态：0-完成，1-未成交，2-部分成交，3-取消
	 */
     private int  status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public double getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
