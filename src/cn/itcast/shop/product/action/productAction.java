package cn.itcast.shop.product.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("productAction")
@Scope("prototype")
public class productAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	private ProductService productService;

	private Integer cid;
	private Integer csid;
	private Integer pid;
	private Integer page;
	
	public Integer getPage() {return page;}
	public void setPage(Integer page) {this.page = page;}
	public Integer getCid() {return cid;}
	public void setCid(Integer cid) {this.cid = cid;}
	public Integer getCsid() {return csid;}
	public void setCsid(Integer csid) {this.csid = csid;}
	public Integer getPid() {return pid;}
	public void setPid(Integer pid) {this.pid = pid;}

	@Resource
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return product;
	}
	
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		return "productInfo";
	}
	
	public String findByPageCid(){
		PageBean pageBean = productService.findByPageCid(cid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "allProduct";
	}
	
	public String findByCsid(){
		PageBean pageBean = productService.findByCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "categorysecondProduct";
	}

}
