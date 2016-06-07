package cn.itcast.shop.adminuser.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.adminuser.model.AdminUser;
import cn.itcast.shop.adminuser.service.AdminUserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<AdminUser>{
	private AdminUser adminUser  = new AdminUser();
	private AdminUserService adminUserService;
	
	@Resource
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	public AdminUser getModel() {
		return adminUser;
	}
	
	public String login(){
		AdminUser existAdminUser = adminUserService.find(adminUser);
		if(existAdminUser == null){
			this.addActionError("用户名或密码错误!请重新输入.");
			return "loginFail";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}

}
