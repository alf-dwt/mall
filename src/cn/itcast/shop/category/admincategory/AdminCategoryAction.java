package cn.itcast.shop.category.admincategory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.category.model.Category;
import cn.itcast.shop.category.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("adminCategoryAction")
@Scope("prototype")
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	private Category category = new Category();
	private CategoryService categoryService;

	@Resource
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getModel() {
		return category;
	}
	
	public String findAll(){
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList",cList);
		return "categoryList";
	}
	
	public String save(){
		categoryService.save(category);
		return "saveSuccess";
	}
	
	public String delete(){
		category = categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		return "deleteSuccess";
	}
	
	public String edit(){
		category = categoryService.findByCid(category.getCid());
		return "edit";
	}
	
	public String update(){
		categoryService.update(category);
		return "updateSuccess";
	}

}
