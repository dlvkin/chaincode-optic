package com.utsoft.blockchain.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.utsoft.blockchain.api.AbstractController;
import com.utsoft.blockchain.api.util.BaseResponse;
import com.utsoft.blockchain.support.service.ItransactionService;
import com.utsoft.blockchain.support.util.ServiceProcessException;
import com.utsoft.blockchain.support.vo.OrdersDescVo;
import com.utsoft.blockchain.support.vo.PersonalAssetVo;

import io.swagger.annotations.Api;
/**
 *  交易相关
 * @author hunterfox
 * @date 2017年7月18日
 */
@RestController
@Api(tags = "transaction", value = "transaction info API")
public class TransactionController extends AbstractController {

	
	@Autowired
	ItransactionService itransactionService;
	
	/**
	 * 获取个人资产信息
	 * @param key 公钥
	 * @param created 10位提交时间戳
	 * @param market
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/get_account", method = RequestMethod.POST)
	public  BaseResponse<PersonalAssetVo>  getPersonAssetsInfo(@RequestParam(required=true) String key,String created,String market,String sign) {
		return BaseResponse.build(itransactionService.getUserAsset(key, created, market));
	}
	
	/**
	 * 买入
	 * @param key 公钥
	 * @param coin_type 币种：1-唐币
	 * @param amount 买入数量
	 * @param price 买入价格
	 * @param created 10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx&price=1)
	 * @param password 如果开启下单输入密码，必须填此参数，不参与签名
	 * @return 
	 */
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public  BaseResponse<Object>  buy(@RequestParam(required=true) String key,@RequestParam(defaultValue="1") int coin_type,
			int amount,double price,String created,String sign,String password) {
		 try {
			 int orderId = itransactionService.orderingBuy(key, coin_type, amount, price, created, sign, password);
			 return BaseResponse.build(orderId).setMessage("success");
		  } catch (ServiceProcessException failException){
			 return BaseResponse.build(201,"failure");
	 	  }	  
	  }

	/**
	 * 卖出
	 * @param key 公钥
	 * @param coin_type 币种：1-唐币
	 * @param amount 买入数量
	 * @param price 买入价格
	 * @param created 10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx&price=1)
	 * @param password 如果开启下单输入密码，必须填此参数，不参与签名
	 * @return 
	 */
	@RequestMapping(value = "/sell", method = RequestMethod.POST)
	public  BaseResponse<Object>  sell(@RequestParam(required=true) String key,@RequestParam(defaultValue="1") int coin_type,
			int amount,double price,String created,String sign,String password) {
		 try {
			 int orderId = itransactionService.orderingSell(key, coin_type, amount, price, created, sign, password);
			 return BaseResponse.build(orderId).setMessage("success");
		  } catch (ServiceProcessException failException){
			 return BaseResponse.build(201,"failure");
	 	  }	  
	  }
	
	/**
	 * 买入市价单
	 * @param key 公钥
	 * @param coin_type 买入总金额
	 * @param amount  卖出总金额
	 * @param created 10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx)
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/buy_from_market", method = RequestMethod.POST)
	public  BaseResponse<Object>  buy_from_market(@RequestParam(required=true) String key,@RequestParam(defaultValue="1") int coin_type,
			double amount,String created,String sign,String password) {
		 try {
			 int orderId = itransactionService.buyFromMarket(key, coin_type, amount, created, sign, password);
			 return BaseResponse.build(orderId).setMessage("success");
		  } catch (ServiceProcessException failException){
			 return BaseResponse.build(201,"failure");
	 	  }	  
	  }
	
	/**
	 * 卖出市价单
	 * @param key 公钥
	 * @param coin_type
	 * @param amount
	 * @param created 10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx)
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/sell_to_market", method = RequestMethod.POST)
	public  BaseResponse<Object>  sell_to_market(@RequestParam(required=true) String key,@RequestParam(defaultValue="1") int coin_type,
		 double amount,String created,String sign,String password) {
		 try {
			 int orderId = itransactionService.sellToMarket(key, coin_type, amount, created, sign, password);
			 return BaseResponse.build(orderId).setMessage("success");
		  } catch (ServiceProcessException failException){
			 return BaseResponse.build(201,"failure");
	 	  }	  
	  }
	
	/**
	 * 查询个人最新成交订单
	 * @param key 公钥
	 * @param coin_type 币种：1-唐币
	 * @param created 10位提交时间戳
	 * @param sign md5签名结果:sign=md5(coin_type=1&created=xxx&key=xxx&trade_id=xxx)
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/get_orders", method = RequestMethod.GET)
	public BaseResponse<PageInfo<OrdersDescVo>> getMyorders(@RequestParam(required=true) String key,@RequestParam(defaultValue="1") int coin_type,String created,String sign
	    ,int pageStart,int pageSize) {
		 return BaseResponse.build(itransactionService.getOrders(key, coin_type, created, sign, pageStart, pageSize));
	}
	/**
	 * 根据交易id查询交易信息
	 * @param key key 公钥
	 * @param coin_type 币种：1-唐币
	 * @param created 10位提交时间戳
	 * @param trade_id 订单号
	 * @param sign  md5签名结果:sign=md5(coin_type=1&created=xxx&key=xxx&trade_id=xxx)
	 * @return
	 */
	@RequestMapping(value = "/get_order_by_trade", method = RequestMethod.GET)
	public BaseResponse<OrdersDescVo> getOrderByTrade(@RequestParam(required=true) String key,@RequestParam(defaultValue="1") int coin_type,String created,String trade_id,String sign) {
		return BaseResponse.build(itransactionService.getOrdersById(key, coin_type, created,trade_id,sign));
	}
	
	/**
	 * 转账
	 * @param key
	 * @param account_from
	 * @param account_to
	 * @param amount
	 * @param created
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/tranfer", method = RequestMethod.POST)
	public BaseResponse<Integer> tranfer(String key,String account_from,String account_to,double amount,String created,String sign) {
		return BaseResponse.build(itransactionService.tranfer(key, account_from, account_to,amount,created,sign));
	}
}
