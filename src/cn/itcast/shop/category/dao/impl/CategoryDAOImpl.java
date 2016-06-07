package cn.itcast.shop.category.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itcast.shop.category.dao.CategoryDAO;
import cn.itcast.shop.category.model.Category;

@Component("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = (List<Category>) this.getHibernateTemplate().find(hql);
		return list;
	}
	public void save(Category category) {
		this.hibernateTemplate.save(category);
	}
	public Category findByCid(Integer cid) {
		return this.hibernateTemplate.get(Category.class, cid);
	}
	public void delete(Category category) {
		this.hibernateTemplate.delete(category);
	}
	public void update(Category category) {
		this.hibernateTemplate.update(category);
	}
}
