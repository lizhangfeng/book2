package com.hzdl.book.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.hzdl.book.dao.OrderDao;
import com.hzdl.book.entity.Order;
import com.hzdl.book.entity.OrderItem;
import com.hzdl.book.uitls.C3P0Utils;

public class OrderDaoImp implements OrderDao {

	@Override
	public int addOrder(Order order) {

		String sql = "insert into book_order values(null,?,?,?,?)";
		try {
			Connection conn = C3P0Utils.getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setObject(1, order.getOrderTime());
			ps.setObject(2, order.getUid());
			ps.setObject(3, order.getAid());
			ps.setObject(4, order.getAllPrice());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()){
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void addOrderItems(List<OrderItem> items) {
		String sql = "insert into order_item values(null,?,?,?,?,?)";
		try {
			Connection conn = C3P0Utils.getDataSource().getConnection();
			//开启自定义事务
			conn.setAutoCommit(false);
			for (OrderItem orderItem : items) {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setObject(1, orderItem.getBid());
				ps.setObject(2, orderItem.getOid());
				ps.setObject(3, orderItem.getBtitle());
				ps.setObject(4, orderItem.getTotal_price());
				ps.setObject(5, orderItem.getBcount());
				ps.executeUpdate();
			}
			conn.commit();//提交事务
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrderPrice(double allPrice) {
		String sql = "update book_order set allPrice=?";
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			qRunner.update(sql,allPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
