package cn.itcast.shop.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.user.dao.UserDAO;
import cn.itcast.shop.user.model.User;
import cn.itcast.shop.user.service.UserService;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public void add(User user) {
		userDAO.save(user);
		
	}

	public User find(User user) {
		return userDAO.find(user);
	}

}
