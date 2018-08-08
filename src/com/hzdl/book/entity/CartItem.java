package com.hzdl.book.entity;

/**
 * 购物车项目
 * 
 * @ClassName: CartItem
 * @Description: TODO
 * @author lzf
 * @date 2018年8月1日 上午11:39:55
 *
 */
public class CartItem {

	private int bid;// 图书id

	private double allPrice;// 总价格

	private String btitle;// 商品名称

	private double BPrice;// 图书的单价

	private int count;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (count <= 1) {
			count = 1;
		}
		this.count = count;
		//数量更新，那么总价格也更新
		setAllPrice(count * BPrice);
	}

	public double getBPrice() {
		return BPrice;
	}

	public void setBPrice(double bPrice) {
		BPrice = bPrice;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	/**
	 * 数量自增
	 */
	public void increment() {
		this.count++;
		setAllPrice(count * BPrice);
	}

	@Override
	public String toString() {
		return "CartItem [bid=" + bid + ", allPrice=" + allPrice + ", count=" + count + "]";
	}

}
