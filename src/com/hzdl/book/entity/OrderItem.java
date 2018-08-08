package com.hzdl.book.entity;

/**
 * 订单项类
 */
public class OrderItem {

	private int id;
	private int bid;
	private int oid;
	private String btitle;
	private double total_price;
	private int bcount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", bid=" + bid + ", oid=" + oid + ", btitle=" + btitle + ", total_price="
				+ total_price + ", bcount=" + bcount + "]";
	}

}
