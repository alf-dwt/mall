package cn.itcast.shop.order.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itcast.shop.order.dao.OrderDAO;
import cn.itcast.shop.order.model.Order;
import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.utils.PageHibernateCallback;

@Component("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Order order) {
		this.hibernateTemplate.save(order);
		
	}

	public int findByUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = (List<Long>) this.hibernateTemplate.find(hql, uid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findByPageUid(Integer uid, int begin, int pagesize) {
		String hql = "from Order o where o.user.uid=? order by ordertime desc";
		List<Order> list = (List<Order>) this.hibernateTemplate.execute((HibernateCallback<Order>) new PageHibernateCallback(hql,new Object[]{uid},begin,pagesize));
		return list;
	}

	public Order findByOid(Integer oid) {
		return this.hibernateTemplate.get(Order.class, oid);
	}

	public void update(Order currOrder) {
		this.hibernateTemplate.update(currOrder);
	}

	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = (List<Long>) this.hibernateTemplate.find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findWithPage(int begin, int pagesize) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = (List<Order>) this.hibernateTemplate.execute((HibernateCallback<Order>) new PageHibernateCallback(hql,null,begin,pagesize));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

	public List<Order> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid=?";
		List<Order> list = (List<Order>) this.hibernateTemplate.find(hql, oid);
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}
	

}
