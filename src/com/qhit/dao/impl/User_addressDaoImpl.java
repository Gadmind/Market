package com.qhit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.dao.User_addressDao;
import com.qhit.entity.User_address;
import com.qhit.util.BaseUtil;

public class User_addressDaoImpl extends BaseUtil implements User_addressDao {

	public List<User_address> getAllAddressByUserId(String loginName) {
		String sql = "SELECT * FROM easybuy_user_address WHERE userId=(SELECT id FROM easybuy_user WHERE loginName=?) ";
		Object[] params = { loginName };
		ResultSet rs = Select(sql, params);
		List<User_address> uaList = new ArrayList<User_address>();
		try {
			while (rs.next()) {
				User_address ua = new User_address(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),
						rs.getInt(5), rs.getString(6));
				uaList.add(ua);
			}
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uaList;
	}

	public String  getAllAddressById(int id) {
		String sql = "SELECT * FROM easybuy_user_address WHERE id=? ";
		Object[] params = { id };
		ResultSet rs = Select(sql, params);
		String address = null;
			try {
				while (rs.next()) {
					address = rs.getString("address");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return address;
	}

}
