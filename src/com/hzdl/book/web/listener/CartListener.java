package com.hzdl.book.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hzdl.book.entity.Cart;

@WebListener
public class CartListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("cart", new Cart());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}
	
}
