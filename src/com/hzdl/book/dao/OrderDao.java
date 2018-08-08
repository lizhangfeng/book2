package com.hzdl.book.dao;

import java.util.List;

import com.hzdl.book.entity.Order;
import com.hzdl.book.entity.OrderItem;

public interface OrderDao {

	/* 插入订单，并返回订单id */
	int addOrder(Order order);
	
	/* 插入订单项 */
	void addOrderItems(List<OrderItem> items);
	
	void updateOrderPrice(double allPrice);
}
