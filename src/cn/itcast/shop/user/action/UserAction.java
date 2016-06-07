package cn.itcast.shop.user.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.user.model.User;
import cn.itcast.shop.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven{
	private User user = new User();
	private UserService userService;
	private String checkcode;
	
	public String registPage(){
		return "registPage";
	}
	
	public String isExist() throws IOException{
		User u = userService.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(u!=null){
			response.getWriter().print("<font color='red'>用户名已存在!</font>");
		}else{
			response.getWriter().print("<font color='green'>用户名可以使用!</font>");
		}
		return NONE;
	}
	
	public String regist(){
		userService.add(user);
		this.addActionMessage("恭喜你注册成功!你现在可以登录了!");
		return "msg";
	}
	
	public String loginPage(){
		return "loginPage";
	}
	
	public String login(){
		String code = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(code)){
			this.addActionError("验证码不正确!");
			return "codeError";
		}
		User existUser = userService.find(user);
		if(existUser == null){
			this.addActionError("用户名或密码不正确!请重新输入!");
			return "loginError";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
		}
		return "loginSuccess";
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public String checkImg(){
		return "checkImg";
	}

	public Object getModel() {
		return user;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	
	
}
