package cn.itcast.shop.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.order.dao.OrderDAO;
import cn.itcast.shop.order.model.Order;
import cn.itcast.shop.order.service.OrderService;
import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.utils.PageBean;

@Component("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDAO;
	
	@Resource
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public void save(Order order) {
		orderDAO.save(order);
		
	}

	public PageBean findByPageUid(Integer uid, Integer page) {
		PageBean pageBean = new PageBean();
		pageBean.setPage(page);
		int pagesize = 4;
		pageBean.setPagesize(pagesize);
		int total = orderDAO.findByUid(uid);
		pageBean.setTotal(total);
		int pageCount = 0;
		if(total / pagesize == 0){
			pageCount = total / pagesize;
		}else {
			pageCount  = total / pagesize + 1;
		}
		pageBean.setPageCount(pageCount);
		int begin = (page-1)*pagesize;
		List<Order> list = orderDAO.findByPageUid(uid,begin,pagesize);
		pageBean.setProList(list);
		return pageBean;
	}

	public Order findByOid(Integer oid) {
		return orderDAO.findByOid(oid);
	}

	public void update(Order currOrder) {
		orderDAO.update(currOrder);
		
	}

	public PageBean<Order> findWithPage(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);
		int pagesize = 10;
		pageBean.setPagesize(pagesize);
		int total = orderDAO.findCount();
		pageBean.setTotal(total);
		int pageCount = 0;
		if(total / pagesize == 0){
			pageCount = total / pagesize;
		}else {
			pageCount  = total / pagesize + 1;
		}
		pageBean.setPageCount(pageCount);
		int begin = (page-1)*pagesize;
		List<Order> list = orderDAO.findWithPage(begin,pagesize);
		pageBean.setProList(list);
		return pageBean;
	}

	public List<Order> findOrderItem(Integer oid) {
		return orderDAO.findOrderItem(oid);
	}

}
