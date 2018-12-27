package com.qhit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qhit.dao.Easybuy_userDao;
import com.qhit.dao.User_addressDao;
import com.qhit.dao.impl.Easybuy_userDaoImpl;
import com.qhit.dao.impl.User_addressDaoImpl;
import com.qhit.entity.Easybuy_user;
import com.qhit.entity.User_address;
import com.qhit.util.Encrypt;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		// Encrypt encrypt = new Encrypt();
		Easybuy_userDao eud = new Easybuy_userDaoImpl();
		User_addressDao uad = new User_addressDaoImpl();
		String loginName = request.getParameter("loginName");
		String passwor = request.getParameter("password");
		String password = Encrypt.e(passwor);
		Easybuy_user easybuy_user = eud.FindUserByLnAndPwd(loginName, password);
		Easybuy_user loginUser = eud.FindUserByLAP(loginName, password);
		List<User_address> uaList = uad.getAllAddressByUserId(loginName);

		session.setAttribute("userAddressList", uaList);
		session.setAttribute("loginUser", loginUser);

		session.setAttribute("easybuy_user", easybuy_user);
		String str = "";
		if (easybuy_user != null) {
			str = "{\"result\":\"success\"}";
		} else {
			str = "{\"result\":\"fail\"}";
		}
		out.print(str);
		out.flush();
		out.close();
	}
}
