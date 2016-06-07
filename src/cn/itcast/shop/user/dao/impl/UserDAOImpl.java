package cn.itcast.shop.user.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itcast.shop.user.dao.UserDAO;
import cn.itcast.shop.user.model.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public User findByUsername(String username) {
		String hql = "from User u where u.username=?";
		List<?> list = (List<?>) hibernateTemplate.find(hql, username);
		if(list != null & list.size() > 0){
			return (User) list.get(0);
		}
		return null;
	}

	public void save(User user) {
		this.hibernateTemplate.save(user);
		
	}

	public User find(User user) {
		String hql = "from User where username=? and password=?";
		List<?> list = (List<?>)this.hibernateTemplate.find(hql, user.getUsername(),user.getPassword());
		if(list != null && list.size()>0){
			return (User)list.get(0);
		}
		return null;
	}
}
