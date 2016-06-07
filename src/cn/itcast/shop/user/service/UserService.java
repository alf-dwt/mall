package cn.itcast.shop.user.service;

import cn.itcast.shop.user.model.User;

public interface UserService {
	public User findByUsername(String username);

	public void add(User user);

	public User find(User user);
}
