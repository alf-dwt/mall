package cn.itcast.shop.index.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.category.model.Category;
import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.product.service.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{
	private CategoryService categoryService;
	private ProductService productService;
	
	@Resource
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Resource
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String execute(){
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getSession().put("cList", cList);
		List<Product> hList = productService.findHot();
		ActionContext.getContext().getValueStack().set("hList", hList);
		List<Product> nList = productService.findNew();
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
}
