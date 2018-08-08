package com.hzdl.book.entity;

import java.util.ArrayList;

/**
 * 购物车对象
 * 
 * @ClassName: Cart
 * @Description: TODO
 * @author lzf
 * @date 2018年8月1日 上午11:39:39
 *
 */
public class Cart extends ArrayList<CartItem> {

	@Override
	public boolean add(CartItem e) {

		for (CartItem item : this) {
			// 如果要添加的商品在购物车里，我们就不添加，数量+1
			if (e.getBid() == item.getBid()) {

				item.increment();// 数量更新，总价格也更新
				return false;
			}
		}

		//表示购物车里面没有这个商品
		e.setCount(1);
		e.setAllPrice(e.getBPrice());
		return super.add(e);
	}

}
