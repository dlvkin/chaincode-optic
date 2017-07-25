package com.utsoft.blockchain.support.service.provider;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.utsoft.blockchain.support.service.ItransactionService;
import com.utsoft.blockchain.support.util.ServiceProcessException;
import com.utsoft.blockchain.support.vo.OrdersDescVo;
import com.utsoft.blockchain.support.vo.PersonalAssetVo;
/**
 * 接下来将要发布具体逻辑
 * @author hunterfox
 * @date 2017年7月18日
 */
@Service
public class TransactionServiceImpl implements ItransactionService {

	@Override
	public PersonalAssetVo getUserAsset(String key, String created, String market) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int orderingBuy(String key, int coin_type, int amount, double price, String created, String sign,
			String password) throws ServiceProcessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int orderingSell(String key, int coin_type, int amount, double price, String created, String sign,
			String password) throws ServiceProcessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int buyFromMarket(String key, int coin_type, double amount, String created, String sign, String password)
			throws ServiceProcessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sellToMarket(String key, int coin_type, double amount, String created, String sign, String password)
			throws ServiceProcessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<OrdersDescVo> getOrders(String key, int coin_type, String created, String sign, int pagStart,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersDescVo getOrdersById(String key, int coin_type, String trade_id, String created, String sign) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tranfer(String key, String account_from, String account_to, double amount, String created, String sign)
			throws ServiceProcessException {
		// TODO Auto-generated method stub
		return 0;
	}
}
