package com.hzdl.book.service;

import java.util.List;

import com.hzdl.book.dao.OrderDao;
import com.hzdl.book.dao.imp.OrderDaoImp;
import com.hzdl.book.entity.Order;
import com.hzdl.book.entity.OrderItem;

/**
 * 订单处理service
 */
public class OrderService {

	private OrderDao dao;

	public OrderService() {
		dao = new OrderDaoImp();
	}

	public int addOrder(Order order) {
		return dao.addOrder(order);
	}

	public void addOrderItems(List<OrderItem> list){
		dao.addOrderItems(list);
	}
	
	public void updateOrderPrice(double allPrice){
		dao.updateOrderPrice(allPrice);
	}
	
}
