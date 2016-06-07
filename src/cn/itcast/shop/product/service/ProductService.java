package cn.itcast.shop.product.service;

import java.util.List;

import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.utils.PageBean;

public interface ProductService {

	List<Product> findHot();

	List<Product> findNew();

	Product findByPid(Integer pid);

	PageBean findByPageCid(Integer cid, Integer page);

	PageBean findByCsid(Integer csid, Integer page);

	PageBean<Product> findWithPage(Integer page);

	void save(Product product);

	void delete(Product product);

	void update(Product product);


}
