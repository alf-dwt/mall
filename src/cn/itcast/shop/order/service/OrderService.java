package cn.itcast.shop.order.service;

import java.util.List;

import cn.itcast.shop.order.model.Order;
import cn.itcast.shop.utils.PageBean;


public interface OrderService {

	void save(Order order);

	PageBean findByPageUid(Integer uid, Integer page);

	Order findByOid(Integer oid);

	void update(Order currOrder);

	PageBean<Order> findWithPage(Integer page);

	List<Order> findOrderItem(Integer oid);

}
