package com.qhit.dao;

import java.util.List;

import com.qhit.entity.User_address;

public interface User_addressDao {
	public List<User_address> getAllAddressByUserId(String loginName);
	public String getAllAddressById(int id);

}
