package cn.itcast.shop.adminuser.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.adminuser.dao.AdminUserDAO;
import cn.itcast.shop.adminuser.model.AdminUser;
import cn.itcast.shop.adminuser.service.AdminUserService;

@Component("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
	private AdminUserDAO adminUserDAO;

	public AdminUserDAO getAdminUserDAO() {
		return adminUserDAO;
	}
	
	@Resource
	public void setAdminUserDAO(AdminUserDAO adminUserDAO) {
		this.adminUserDAO = adminUserDAO;
	}

	public AdminUser find(AdminUser adminUser) {
		return adminUserDAO.find(adminUser);
	}

}
