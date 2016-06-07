package cn.itcast.shop.product.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itcast.shop.product.dao.ProductDAO;
import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.utils.PageHibernateCallback;

@Component("productDAO")
public class ProductDAOImpl implements ProductDAO {
	private HibernateTemplate hibernateTemplate;
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Product> findHot() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = (List<Product>) this.hibernateTemplate.findByCriteria(criteria,0,10);
		return list;
	}

	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = (List<Product>) this.hibernateTemplate.findByCriteria(criteria,0,10);
		return list;
	}

	public Product findByPid(Integer pid) {
		String hql = "from Product where pid=?";
		List<Product> list = (List<Product>)this.hibernateTemplate.find(hql, pid);
		if(list != null && list.size()>0){
			return (Product) list.get(0);
		}
		return null;
	}

	public int findByCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = (List<Long>) this.hibernateTemplate.find(hql, cid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPageCid(Integer cid, int begin, int pagesize) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		List<Product> list = (List<Product>) this.hibernateTemplate.execute((HibernateCallback<Product>) new PageHibernateCallback(hql,new Object[]{cid},begin,pagesize));
		return list;
	}

	public int findByCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = (List<Long>) this.hibernateTemplate.find(hql, csid);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPageCsid(Integer csid, int begin, int pagesize) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list = (List<Product>) this.hibernateTemplate.execute((HibernateCallback<Product>) new PageHibernateCallback(hql,new Object[]{csid},begin,pagesize));
		return list;
	}

	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = (List<Long>) this.hibernateTemplate.find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findWithPage(int begin, int pagesize) {
		String hql = "from Product order by pdate desc";
		List<Product> list = (List<Product>) this.hibernateTemplate.execute((HibernateCallback<Product>) new PageHibernateCallback(hql,null,begin,pagesize));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

	public void save(Product product) {
		this.hibernateTemplate.persist(product);
	}

	public void delete(Product product) {
		this.hibernateTemplate.delete(product);
	}

	public void update(Product product) {
		
		this.hibernateTemplate.update(product);
	}

}
