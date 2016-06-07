package cn.itcast.shop.category.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.category.dao.CategoryDAO;
import cn.itcast.shop.category.model.Category;
import cn.itcast.shop.category.service.CategoryService;

@Component("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
	private CategoryDAO categoryDAO;

	@Resource
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public List<Category> findAll() {
		
		return categoryDAO.findAll();
	}

	public void save(Category category) {
		categoryDAO.save(category);
	}

	public void delete(Integer cid) {
		
	}

	public Category findByCid(Integer cid) {
		return categoryDAO.findByCid(cid);
	}

	public void delete(Category category) {
		categoryDAO.delete(category);
	}

	public void update(Category category) {
		categoryDAO.update(category);
	}
	
}
