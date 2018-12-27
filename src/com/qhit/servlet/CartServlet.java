package com.qhit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.qhit.dao.OrderDao;
import com.qhit.dao.ProductDao;
import com.qhit.dao.User_addressDao;
import com.qhit.dao.impl.OrderDaoImpl;
import com.qhit.dao.impl.ProductDaoImpl;
import com.qhit.dao.impl.User_addressDaoImpl;
import com.qhit.entity.Carts;
import com.qhit.entity.Easybuy_user;
import com.qhit.entity.Order;
import com.qhit.entity.Product;
import com.qhit.util.CartUtil;
import com.qhit.util.RandomNumber;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("TEXT/HTML;CHARSET=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ProductDao pd = new ProductDaoImpl();
		String action = request.getParameter("action");

		if (action.equals("add")) {
			String entityId = request.getParameter("entityId");
			String quantity = request.getParameter("quantity");
			session.setAttribute("quantity", quantity);
			session.setAttribute("entityId", entityId);
			String str = "{\"status\":\"" + 1 + "\"}";
			out.print(str);
			out.flush();
			out.close();
		}
		if (action.equals("refreshCart")) {
			// 1.获取session中购物车
			Carts carts = (Carts) session.getAttribute("cart");
			if (carts == null) {
				carts = new Carts();
			}
			List<CartUtil> items = carts.getItems();
			if (items == null) {
				items = new ArrayList<CartUtil>();
			}

			String entity = (String) session.getAttribute("entityId");
			String quan = (String) session.getAttribute("quantity");
			if (entity != null && quan != null) {
				Integer quantity = Integer.parseInt(quan);
				Integer entityId = Integer.parseInt(entity);
				for (int i = 0; i < items.size(); i++) {
					if (items.get(i).getProduct().getId() == entityId) {
						items.get(i).setQuantity(items.get(i).getQuantity() + quantity);
						items.get(i).setCost(quantity * items.get(i).getProduct().getPrice());
						carts.setSum(items);
						session.setAttribute("cart", carts);
						response.sendRedirect("common/pre/searchBar.jsp");
						return;
					}
				}
				Product product = pd.getProductById(entityId);
				CartUtil item = new CartUtil(product, quantity);
				items.add(item);
				carts.setItems(items);
				carts.setSum(items);
				session.setAttribute("cart", carts);
				session.removeAttribute("entityId");
				session.removeAttribute("quantity");
			}
			response.sendRedirect("common/pre/searchBar.jsp");
		}
		if (action.equals("toSettlement")) {
			response.sendRedirect("pre/settlement/toSettlement.jsp");
		}
		if (action.equals("modCart")) {
		}
		if (action.equals("settlement1")) {
			response.sendRedirect("pre/settlement/settlement1.jsp");
		}
		if (action.equals("settlement2")) {
			session.getAttribute("loginUser");
			response.sendRedirect("pre/settlement/settlement2.jsp");
		}
		if (action.equals("settlement3")) {
			OrderDao od = new OrderDaoImpl();
			Carts cu = (Carts) session.getAttribute("cart");
			Easybuy_user user = (Easybuy_user) session.getAttribute("loginUser");
			User_addressDao uad = new User_addressDaoImpl();
			String Address = request.getParameter("addressId");
			String newAddress = null;
			if (Address.equals("-1")) {
				newAddress = request.getParameter("newAddress");
			} else {
				Integer selectAddress=Integer.parseInt(Address);
				newAddress = uad.getAllAddressById(selectAddress);
			}
			SimpleDateFormat simpl = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String createTime = simpl.format(new Date());
			float cost = cu.getSum();
			String serialNumber = RandomNumber.randomUUID();
			System.out.println(newAddress);
			Order order = new Order(0, user.getId(), user.getLoginName(), newAddress, createTime, cost, serialNumber);
			int flag = od.saveOrder(order);
			if (flag > 0) {
				session.removeAttribute("cart");
				session.setAttribute("currentOrder", order);
				request.getRequestDispatcher("pre/settlement/settlement3.jsp").forward(request, response);
			}
		}
	}

}
