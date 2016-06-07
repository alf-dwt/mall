package cn.itcast.shop.cart.model;

import cn.itcast.shop.product.model.Product;

public class CartItem {
	private Product product; //购物项中的商品信息
	private int count; //商品数量
	private double subtotal; //商品小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*(product.getShop_price());
	}
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}*/
	
}
