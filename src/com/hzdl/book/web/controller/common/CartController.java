package com.hzdl.book.web.controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzdl.book.entity.Book;
import com.hzdl.book.entity.Cart;
import com.hzdl.book.entity.CartItem;
import com.hzdl.book.service.BookService;

/**
 * 处理购物车的
 * 
 * @ClassName: CartController
 * @Description: TODO
 * @author lzf
 * @date 2018年8月1日 上午11:35:58
 *
 */
@WebServlet("/cart/*")
public class CartController extends HttpServlet {

	private BookService service;

	public CartController() {
		service = new BookService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("/add")) {// 添加到购物车中
			addCart(req, resp);
		} else if (uri.contains("/toCart")) {// 跳转购物车页面
			req.getRequestDispatcher("/WEB-INF/jsp/common/cart.jsp").forward(req, resp);
		} else if (uri.contains("/changeNum")) {// 修改数量
			changeNum(req, resp);
		} else if (uri.contains("/delete")) {// 删除购物车中的商品
			deleteCart(req, resp);
		}
	}

	private void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bid = Integer.parseInt(req.getParameter("bid"));
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		// 记录
		int deltePos = -1;
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getBid() == bid) {// 找到了要删除的商品
				deltePos = i;
				break;
			}
		}
		if (deltePos != -1) {
			cart.remove(deltePos);
		}
		req.getSession().setAttribute("cart", cart);
		req.getRequestDispatcher("/WEB-INF/jsp/common/cart.jsp").forward(req, resp);
	}

	private void changeNum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bid = Integer.parseInt(req.getParameter("bid"));
		int count = Integer.parseInt(req.getParameter("count"));
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		for (CartItem item : cart) {
			if (item.getBid() == bid) {
				item.setCount(count);
				break;
			}
		}
		req.getSession().setAttribute("cart", cart);
		req.getRequestDispatcher("/WEB-INF/jsp/common/cart.jsp").forward(req, resp);
	}

	/**
	 * 添加商品到购物车中
	 */
	private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取到id
		String bid = req.getParameter("bid");
		// 2. 从数据库中找到对应的商品（书）
		Book book = service.getBookByID(bid);
		// 3. 获取一个购物车对象
		Cart cart = null;
		if (req.getSession().getAttribute("cart") == null) {
			cart = new Cart();
		} else {
			cart = (Cart) req.getSession().getAttribute("cart");
		}
		// 4. 把Book变成购物车item对象
		CartItem item = new CartItem();
		item.setBid(book.getBID());
		item.setBPrice(Double.parseDouble(book.getBPrice()));
		item.setBtitle(book.getBTitle());
		cart.add(item);
		// 5.重新吧cart对象放入到session中
		req.getSession().setAttribute("cart", cart);

		req.getRequestDispatcher("/WEB-INF/jsp/common/cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
