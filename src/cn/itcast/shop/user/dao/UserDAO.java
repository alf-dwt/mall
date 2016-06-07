package cn.itcast.shop.user.dao;

import cn.itcast.shop.user.model.User;

public interface UserDAO {
	public User findByUsername(String username);

	public void save(User user);

	public User find(User user);
}
