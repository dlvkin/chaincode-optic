package com.utsoft.blockchain.support.dao.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户基本信息
 * @author hunterfox
 * @date 2017年7月17日
 */
@Table(name = "t_user_info")
public class UserInfoPo implements Serializable {

	private static final long serialVersionUID = 13232434286L;
	@Id
	@Column(name = "userid")
	private  Integer userid;
	
	@Column(name = "appId")
	private  String appId;
	
	private  String secret;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_create")
    private Date gmtCreate;
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
}
