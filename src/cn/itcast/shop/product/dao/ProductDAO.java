package cn.itcast.shop.product.dao;

import java.util.List;

import cn.itcast.shop.product.model.Product;

public interface ProductDAO {

	List<Product> findHot();

	List<Product> findNew();

	Product findByPid(Integer pid);

	int findByCid(Integer cid);

	List<Product> findByPageCid(Integer cid, int begin, int pagesize);

	int findByCsid(Integer csid);

	List<Product> findByPageCsid(Integer csid, int begin, int pagesize);

	int findCount();

	List<Product> findWithPage(int begin, int pagesize);

	void save(Product product);

	void delete(Product product);

	void update(Product product);

}
