package com.qhit.dao;

import com.qhit.entity.Easybuy_user;

public interface Easybuy_userDao {
	// 通过登录名和用户名查询用户
	public Easybuy_user FindUserByLnAndUn(String loginName, String userNae);
	//登陆
	public Easybuy_user FindUserByLnAndPwd(String loginName, String password);
	public Easybuy_user FindUserByLAP(String loginName, String password);
	// 注册RegisterUser(loginName,userName,password,sex,identityCode,email,mobile)
	public int RegisterUser(String loginName, String userName, String password, int sex, String identityCode,
			String email, String mobile);

}
