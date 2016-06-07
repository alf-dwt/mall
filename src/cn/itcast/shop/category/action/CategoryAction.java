package cn.itcast.shop.category.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.category.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

@Component("categoryAction")
@Scope("prototype")
public class CategoryAction extends ActionSupport {
	private CategoryService categoryService;

	@Resource
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
