package cn.itcast.shop.cart.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.cart.model.Cart;
import cn.itcast.shop.cart.model.CartItem;
import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.product.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;

@Component("cartAction")
@Scope("prototype")
public class CartAction extends ActionSupport {
	private Integer pid;
	private Integer count;
	private ProductService productService;
	
	@Resource(name="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String addCart(){
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		Cart cart = getCart();
		cart.addItem(cartItem);
		return "addCart";
	}
	
	public String clearCart(){
		getCart().clearCart();
		return "clearCart";
	}
	
	public String removeCart(){
		getCart().removeItem(pid);
		return "removeCart";
	}
	
	public String goCart(){
		return "goCart";
	}

	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
