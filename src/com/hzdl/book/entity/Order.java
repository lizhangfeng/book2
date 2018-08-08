package com.hzdl.book.entity;

import java.util.List;

/**
 * 订单类
 */
public class Order {

	private int oid;
	private String orderTime;
	private int uid;
	private int aid;
	private double allPrice;//总价

	private List<OrderItem> list;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderTime=" + orderTime + ", uid=" + uid + ", aid=" + aid + "]";
	}

}
