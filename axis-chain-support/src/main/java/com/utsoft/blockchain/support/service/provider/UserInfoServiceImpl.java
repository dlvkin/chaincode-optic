package com.utsoft.blockchain.support.service.provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsoft.blockchain.support.dao.mapper.IuserInfoMapper;
import com.utsoft.blockchain.support.service.IUserInfoService;
/**
 * 接下来将要发布具体逻辑
 * @author hunterfox
 * @date 2017年7月18日
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IuserInfoMapper  userInfoMapper;
	
	@Override
	public void getUserById(int userId) {
		userInfoMapper.selectByPrimaryKey(userId);
	}
}
