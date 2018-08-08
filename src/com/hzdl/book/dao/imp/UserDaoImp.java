package com.hzdl.book.dao.imp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hzdl.book.dao.UserDao;
import com.hzdl.book.entity.User;
import com.hzdl.book.uitls.C3P0Utils;

public class UserDaoImp implements UserDao {

	private QueryRunner qRunner;

	public UserDaoImp() {
		qRunner = new QueryRunner(C3P0Utils.getDataSource());
	}

	@Override
	public boolean exist(String userName) {

		String sql = "select * from userinfo where ULoginID=?";

		try {
			User user = qRunner.query(sql, userName, new BeanHandler<>(User.class));
			if (user == null) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User getUserByNameAndPwd(String ULoginID, String ULoginPsw) {
		String sql = "select * from userinfo where ULoginID=? and ULoginPsw=?";
		try {
			User user = qRunner.query(sql, new Object[]{ULoginID,ULoginPsw},new BeanHandler<>(User.class));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
