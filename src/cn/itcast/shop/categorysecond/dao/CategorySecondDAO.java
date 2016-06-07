package cn.itcast.shop.categorysecond.dao;

import java.util.List;

import cn.itcast.shop.categorysecond.model.CategorySecond;
import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.product.model.Product;

public interface CategorySecondDAO {

	int findCount();

	List<CategorySecond> findAllWithPage(int begin, int pagesize);

	void save(CategorySecond categorySecond);

	CategorySecond findByCsid(Integer csid);

	void delete(CategorySecond categorySecond);

	void update(CategorySecond categorySecond);

	List<CategorySecond> findAll();


}
