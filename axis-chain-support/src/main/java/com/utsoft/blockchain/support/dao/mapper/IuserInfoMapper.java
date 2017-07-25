package com.utsoft.blockchain.support.dao.mapper;
import org.springframework.stereotype.Repository;
import com.utsoft.blockchain.support.dao.MySqlBaseMapper;
import com.utsoft.blockchain.support.dao.model.UserInfoPo;
/**
 * 用户基本信息
 * @author hunterfox
 * @date 2017年7月18日
 */
@Repository
public interface IuserInfoMapper extends MySqlBaseMapper<UserInfoPo> {

}
