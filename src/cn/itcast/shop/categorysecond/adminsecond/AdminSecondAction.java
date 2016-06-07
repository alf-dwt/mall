package cn.itcast.shop.categorysecond.adminsecond;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.category.model.Category;
import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.categorysecond.model.CategorySecond;
import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("adminSecondAction")
@Scope("prototype")
public class AdminSecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	private CategorySecond categorySecond = new CategorySecond();
	private CategorySecondService categorySecondService;
	private CategoryService categoryService;
	
	@Resource(name="categoryService")
	public void setSecondService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPage() {
		return page;
	}

	@Resource(name="categorySecondService")
	public void setCategoryService(CategorySecondService categoryService) {
		this.categorySecondService = categoryService;
	}

	public CategorySecond getModel() {
		return categorySecond;
	}
	
	public String findAll(){
		PageBean<CategorySecond> pageBean = categorySecondService.findAllByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	public String addPage(){
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	
	public String store(){
		categorySecondService.save(categorySecond);
		return "store";
	}
	
	public String delete(){
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	public String edit(){
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}
	
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	
}
