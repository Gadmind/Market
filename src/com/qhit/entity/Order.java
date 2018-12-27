package com.qhit.entity;



public class Order {
	/*
	 * id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键', `userId` int(255) DEFAULT
	 * NULL COMMENT '用户主键', `loginName` varchar(255) DEFAULT NULL, `userAddress`
	 * varchar(255) DEFAULT NULL COMMENT '用户地址', `createTime` datetime DEFAULT NULL
	 * COMMENT '创建时间', `cost` float DEFAULT NULL COMMENT '总消费', `serialNumber`
	 * varchar(255) DEFAULT NULL COMMENT '订单号
	 */
	private int id;
	private int userId;
	private String loginName;
	private String userAddress;
	private String creatTime;
	private float cost;
	private String serialNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Order(int id, int userId, String loginName, String userAddress, String createTime, float cost,
			String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.creatTime = createTime;
		this.cost = cost;
		this.serialNumber = serialNumber;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", loginName=" + loginName + ", userAddress=" + userAddress
				+ ", creatTime=" + creatTime + ", cost=" + cost + ", serialNumber=" + serialNumber + "]";
	}

}
