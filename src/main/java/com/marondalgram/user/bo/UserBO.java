package com.marondalgram.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondalgram.user.dao.UserDAO;
import com.marondalgram.user.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	public int existLoginId(String loginId) {
		return userDAO.existLoginId(loginId);
	}
	
	public int insertUser(String loginId, String password, String name, String email) {
		return userDAO.insertUser(loginId, password, name, email);
	}
	
	public User getUser(String loginId, String password) {
		return userDAO.selectUserByLoginIdPassword(loginId, password);
	}
	
	public User getUserById(int userId) {
		return userDAO.selectUserById(userId);
	}
}



