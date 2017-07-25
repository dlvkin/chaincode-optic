package com.utsoft.blockchain.support.service;
import com.github.pagehelper.PageInfo;
import com.utsoft.blockchain.support.util.ServiceProcessException;
import com.utsoft.blockchain.support.vo.OrdersDescVo;
import com.utsoft.blockchain.support.vo.PersonalAssetVo;
/**
 * 交易相关和查询
 * @author hunterfox
 * @date 2017年7月18日
 */
public interface ItransactionService {

	/**
	 * 获取个人资产信息
	 * @param key
	 * @param created
	 * @param market
	 * @return
	 */
	public PersonalAssetVo getUserAsset(String key,String created,String market);
	
	/**
	 *  买入
	 * @param key 公钥
	 * @param coin_type币种：1-唐币
	 * @param amount
	 * @param price
	 * @param created 10位提交时间戳
	 * @param sign
	 * @param password
	 * @return
	 * @throws ServiceProcessException
	 */
	public int orderingBuy(String key,int coin_type,int amount,double price,String created,String sign,String password) throws ServiceProcessException;
	
	/**
	 *  卖出
	 * @param key 公钥
	 * @param coin_type 币种：1-唐币
	 * @param amount
	 * @param price
	 * @param created 10位提交时间戳
	 * @param sign
	 * @param password
	 * @return
	 * @throws ServiceProcessException
	 */
	public int orderingSell(String key,int coin_type,int amount,double price,String created,String sign,String password) throws ServiceProcessException;

	/**
	 * 买入市价单
	 * @param key  公钥
	 * @param coin_type  币种：1-唐币
	 * @param amount
	 * @param created  10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx)
	 * @param password 如果开启下单输入密码，必须填此参数，不参与签名
	 * @return
	 * @throws ServiceProcessException
	 */
	public int buyFromMarket(String key,int coin_type,double amount,String created,String sign,String password) throws ServiceProcessException;



	/**
	 * 卖出市价单
	 * @param key  公钥
	 * @param coin_type  币种：1-唐币
	 * @param amount
	 * @param created   10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx)
	 * @param password 如果开启下单输入密码，必须填此参数，不参与签名
	 * @return
	 * @throws ServiceProcessException
	 */
	public int sellToMarket(String key,int coin_type,double amount,String created,String sign,String password) throws ServiceProcessException;

	/**
	 * 查询个人最新成交订单
	 * @param key 公钥
	 * @param coin_type 币种：1-唐币
	 * @param created  10位提交时间戳
	 * @param sign md5签名结果:sign=md5(coin_type=1&created=xxx&key=xxx)
	 * @param pagStart
	 * @param pageSize
	 * @return
	 */

	PageInfo<OrdersDescVo> getOrders(String key,int coin_type,String created,String sign,int pagStart,int pageSize);

	/**
	 * 根据交易id查询交易信息
	 * @param key 公钥
	 * @param coin_type 币种：1-唐币
	 * @param trade_id  交易订单号
	 * @param created  10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx)
	 * @return
	 */
	OrdersDescVo getOrdersById(String key,int coin_type,String trade_id,String created,String sign);

	/**
	 * 转账
	 * @param key 公钥
	 * @param account_from 转出账户
	 * @param account_to 转入账户
	 * @param amount 转账数量
	 * @param created  10位提交时间戳
	 * @param sign md5签名结果:sign=md5(amount=1&coin_type=1&created=xxx&key=xxx)
	 * @return
	 */
	public int tranfer(String key,String account_from,String account_to,double amount,String created,String sign) throws ServiceProcessException;;
}
