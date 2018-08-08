package com.hzdl.book.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.entity.Cart;
import com.hzdl.book.entity.CartItem;
import com.hzdl.book.entity.Order;
import com.hzdl.book.entity.OrderItem;
import com.hzdl.book.entity.User;
import com.hzdl.book.service.OrderService;
import com.hzdl.book.uitls.DateUtils;

@WebServlet("/order/*")
public class OrderController extends HttpServlet {

	private OrderService service;

	public OrderController() {
		service = new OrderService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("/user/addOrder")) {// 用户提交订单-创建订单

			User user = (User) req.getSession().getAttribute("user");
			if (user == null) {// 没有登录或登录已经失效
				resp.sendRedirect("http://localhost:8080/bookstore/user/toLogin");
			} else {
				// 获取购物车中的商品
				Cart cart = (Cart) req.getSession().getAttribute("cart");
				// 插入订单
				Order order = new Order();
				order.setUid(user.getUID());
				order.setOrderTime(DateUtils.getNowTime());
				int oid = service.addOrder(order);
				// 订单项
				List<OrderItem> list = new ArrayList<>();
				double allPrice = 0;
				for (CartItem cartItem : cart) {
					OrderItem orderItem = new OrderItem();
					orderItem.setBcount(cartItem.getCount());
					orderItem.setBid(cartItem.getBid());
					orderItem.setBtitle(cartItem.getBtitle());
					orderItem.setOid(oid);
					orderItem.setTotal_price(cartItem.getAllPrice());
					allPrice += cartItem.getAllPrice();
					list.add(orderItem);
				}
				service.addOrderItems(list);
				// 插入总价并更新订单表
				order.setAllPrice(allPrice);
				service.updateOrderPrice(allPrice);

				// 最后把购物车清空
				cart.clear();
				req.getSession().setAttribute("cart", cart);
				resp.getWriter().println("提交订单成功！");
				resp.getWriter().close();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
