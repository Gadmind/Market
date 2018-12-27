package com.qhit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qhit.dao.ProductCategoryDao;
import com.qhit.dao.ProductDao;
import com.qhit.dao.impl.ProductCategoryDaoImpl;
import com.qhit.dao.impl.ProductDaoImpl;
import com.qhit.entity.Product;
import com.qhit.entity.ProductCategoryVo;

/**
 * Servlet implementation class ProServlet
 */
public class ProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ProductCategoryDao epcd = new ProductCategoryDaoImpl();
		ProductDao pd = new ProductDaoImpl();
		HttpSession session = request.getSession();
		String mark = request.getParameter("mark");
		if (mark.equals("first")) {
			List<ProductCategoryVo> list = epcd.getAllProductCategory();
			session.setAttribute("productCategoryVoList", list);
			response.sendRedirect("pre/index.jsp");
			return;
		}
		if (mark.equals("queryProductDeatil")) {
			String i = request.getParameter("id");
			Integer id = Integer.parseInt(i);
			Product product = pd.getProductById(id);
			session.setAttribute("product", product);
			response.sendRedirect("pre/product/productDeatil.jsp");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}