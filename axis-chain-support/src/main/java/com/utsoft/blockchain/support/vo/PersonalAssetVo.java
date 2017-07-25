package com.utsoft.blockchain.support.vo;
import java.io.Serializable;
/**
 * 个人资产
 * @author hunterfox
 * @date 2017年7月18日
 */
public class PersonalAssetVo implements Serializable {
	private static final long serialVersionUID = -6217395086060284504L;
	/**
	 * 总资产
	 */
	 private double total;
	 /**
	  * 可用人民币
	  */
	 private double available_cny;
	 /**
	  * 可用唐币
	  */
     private int available_tk;
	
    public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getAvailable_cny() {
		return available_cny;
	}
	public void setAvailable_cny(double available_cny) {
		this.available_cny = available_cny;
	}
	public int getAvailable_tk() {
		return available_tk;
	}
	public void setAvailable_tk(int available_tk) {
		this.available_tk = available_tk;
	}
	
	@Override
	public String toString() {
		return "PersonalAssets [total=" + total + ", available_cny=" + available_cny + ", available_tk=" + available_tk
				+ "]";
	}  
}
