package cn.itcast.shop.adminuser.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itcast.shop.adminuser.dao.AdminUserDAO;
import cn.itcast.shop.adminuser.model.AdminUser;

@Component("AdminUserDAO")
public class AdminUserDAOImpl implements AdminUserDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public AdminUser find(AdminUser adminUser) {
		String hql = "from AdminUser where username=? and password=?";
		List<AdminUser> list = (List<AdminUser>) this.hibernateTemplate.find(hql, adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	

}
