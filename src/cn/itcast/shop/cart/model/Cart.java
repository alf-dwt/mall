package cn.itcast.shop.cart.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
	
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	private double total; //商品总计
	
	public double getTotal() {
		return total;
	}

	//添加到购物车的功能
	public void addItem(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
		}else {
			map.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();
	}
	
	//从购物车中移除
	public void removeItem(Integer pid){
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	
	//清空购物车
	public void clearCart(){
		map.clear();
		total = 0;
	}
	
}
