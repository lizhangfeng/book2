package com.hzdl.book.dao;

import com.hzdl.book.entity.User;

public interface UserDao {

	// 检查用户是否存在
	boolean exist(String userName);

	User getUserByNameAndPwd(String ULoginID,String ULoginPsw);
	
}
