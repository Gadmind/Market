package com.qhit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qhit.dao.Easybuy_userDao;
import com.qhit.dao.impl.Easybuy_userDaoImpl;
import com.qhit.entity.Easybuy_user;
import com.qhit.util.Encrypt;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//Encrypt encrypt = new Encrypt();
		Easybuy_userDao eud = new Easybuy_userDaoImpl();

		String loginName = request.getParameter("loginName");
		String userName = request.getParameter("userName");
		String passwor = request.getParameter("password");
		String password = Encrypt.e(passwor);
		String se = request.getParameter("sex");
		Integer sex = Integer.parseInt(se);
		String identityCode = request.getParameter("identityCode");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		Easybuy_user easybuy_user = eud.FindUserByLnAndUn(loginName, userName);
		session.setAttribute("easybuy_user", easybuy_user);
		String str = "";
		if (easybuy_user != null) {
		str = "{\"result\":\"exit\"}";
		//	out.print("<script type='text/javascript'>alert('该用户已存在'); window.location.href='register.jsp';</script>");
		} else {
			int i = eud.RegisterUser(loginName, userName, password, sex, identityCode, email, mobile);
			if (i == 1) {
				str = "{\"result\":\"success\"}";
				// out.print("<script type='text/javascript'>alert('注册成功');
				// window.location.href='login.jsp';</script>");
			} else {
				str = "{\"result\":\"fail\"}";
				// out.print(
				// "<script type='text/javascript'>alert('注册失败');
				// window.location.href='register.jsp';</script>");
			}
		}
		out.print(str);

	}

}
