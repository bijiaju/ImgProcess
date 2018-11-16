package com.bee.pojo;

import java.util.Date;

public class WeChatOrder {
	

	private String comName;
	
	private String rmb;//人民币
	private String status;//支付状态
	private String tradeName;//支付状态
	private String shopName;//支付状态
	private String payway;//支付状态
	private String orderId;//支付状态
	private Date payTime;//支付状态
	private String shopId;//商户id
	private String barId;//
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getRmb() {
		return rmb;
	}
	public void setRmb(String rmb) {
		this.rmb = rmb;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getBarId() {
		return barId;
	}
	public void setBarId(String barId) {
		this.barId = barId;
	}
	@Override
	public String toString() {
		return "WeChatOrder [status=" + status + ", tradeName=" + tradeName + ", shopName=" + shopName + ", payway="
				+ payway + ", orderId=" + orderId + ", payTime=" + payTime + ", shopId=" + shopId + "]";
	}
	
	

}
