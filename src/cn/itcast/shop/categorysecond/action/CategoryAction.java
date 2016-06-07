package cn.itcast.shop.categorysecond.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.categorysecond.service.CategorySecondService;

import com.opensymphony.xwork2.ActionSupport;

@Component("categorySecondAction")
@Scope("prototype")
public class CategoryAction extends ActionSupport {
	private CategorySecondService categoryService;
	
	@Resource(name="categorySecondService")
	public void setCategoryService(CategorySecondService categoryService) {
		this.categoryService = categoryService;
	}

}
