package cn.itcast.shop.categorysecond.service;

import java.util.List;

import cn.itcast.shop.categorysecond.model.CategorySecond;
import cn.itcast.shop.utils.PageBean;

public interface CategorySecondService {

	PageBean<CategorySecond> findAllByPage(Integer page);

	void save(CategorySecond categorySecond);

	CategorySecond findByCsid(Integer csid);

	void delete(CategorySecond categorySecond);

	void update(CategorySecond categorySecond);

	List<CategorySecond> findAll();


}
