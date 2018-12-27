package com.qhit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.dao.Easybuy_userDao;
import com.qhit.entity.Easybuy_user;
import com.qhit.util.BaseUtil;

public class Easybuy_userDaoImpl extends BaseUtil implements Easybuy_userDao {

	public Easybuy_user FindUserByLnAndUn(String loginName, String userName) {
		String sql = "SELECT loginName,userName FROM EASYBUY_USER WHERE loginname=? AND userName=?";
		Object[] params = { loginName, userName };
		ResultSet rs = Select(sql, params);
		Easybuy_user eu = null;
		try {
			while (rs.next()) {
				eu = new Easybuy_user();
				eu.setLoginName(rs.getString("loginName"));
				eu.setPassword(rs.getString("userName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;
	}

	public int RegisterUser(String loginName, String userName, String password, int sex, String identityCode,
			String email, String mobile) {
		String sql = "INSERT INTO EASYBUY_USER (loginName,userName,password,sex,identityCode,email,mobile) VALUES(?,?,?,?,?,?,?)";
		Object[] params = { loginName, userName, password, sex, identityCode, email, mobile };
		int i = DeleteInsertUpDate(sql, params);
		return i;
	}

	public Easybuy_user FindUserByLnAndPwd(String loginName, String password) {
		String sql = "SELECT loginName,password FROM EASYBUY_USER WHERE loginName=? AND password=?";
		Object[] params = { loginName, password };
		ResultSet rs = Select(sql, params);
		Easybuy_user eu = null;
		try {
			while (rs.next()) {
				eu = new Easybuy_user();
				eu.setLoginName(rs.getString("loginName"));
				eu.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;
	}

	public Easybuy_user FindUserByLAP(String loginName, String password) {
		// rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
		// rs.getInt(5),
		// rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)
		String sql = "SELECT * FROM EASYBUY_USER WHERE loginname=? AND password=?";
		Object[] params = { loginName, password };
		ResultSet rs = Select(sql, params);
		Easybuy_user eu = null;
		try {
			while (rs.next()) {
				eu = new Easybuy_user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eu;
	}

}
