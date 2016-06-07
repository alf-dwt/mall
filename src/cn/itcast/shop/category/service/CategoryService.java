package cn.itcast.shop.category.service;

import java.util.List;

import cn.itcast.shop.category.model.Category;

public interface CategoryService {

	List<Category> findAll();

	void save(Category category);

	void delete(Integer cid);

	Category findByCid(Integer cid);

	void delete(Category category);

	void update(Category category);
	
	

}
