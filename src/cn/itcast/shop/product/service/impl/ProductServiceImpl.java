package cn.itcast.shop.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.product.dao.ProductDAO;
import cn.itcast.shop.product.model.Product;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.utils.PageBean;

@Component("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	
	@Resource
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Product> findHot() {
		return productDAO.findHot();
	}

	public List<Product> findNew() {
		return productDAO.findNew();
	}

	public Product findByPid(Integer pid) {
		return productDAO.findByPid(pid);
	}

	public PageBean findByPageCid(Integer cid, Integer page) {
		PageBean pageBean = new PageBean();
		pageBean.setPage(page);
		int pagesize = 12;
		pageBean.setPagesize(pagesize);
		int total = productDAO.findByCid(cid);
		pageBean.setTotal(total);
		int pageCount = 0;
		if(total / pagesize == 0){
			pageCount = total / pagesize;
		}else {
			pageCount  = total / pagesize + 1;
		}
		pageBean.setPageCount(pageCount);
		int begin = (page-1)*pagesize;
		List<Product> list = productDAO.findByPageCid(cid,begin,pagesize);
		pageBean.setProList(list);
		return pageBean;
	}

	public PageBean findByCsid(Integer csid,Integer page) {
		PageBean pageBean = new PageBean();
		pageBean.setPage(page);
		int pagesize = 8;
		pageBean.setPagesize(pagesize);
		int total = productDAO.findByCsid(csid);
		pageBean.setTotal(total);
		int pageCount = 0;
		if(total / pagesize == 0){
			pageCount = total / pagesize;
		}else {
			pageCount  = total / pagesize + 1;
		}
		pageBean.setPageCount(pageCount);
		int begin = (page-1)*pagesize;
		List<Product> list = productDAO.findByPageCsid(csid,begin,pagesize);
		pageBean.setProList(list);
		return pageBean;
	}

	public PageBean<Product> findWithPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page);
		int pagesize = 10;
		pageBean.setPagesize(pagesize);
		int total = productDAO.findCount();
		pageBean.setTotal(total);
		int pageCount = 0;
		if(total / pagesize == 0){
			pageCount = total / pagesize;
		}else {
			pageCount  = total / pagesize + 1;
		}
		pageBean.setPageCount(pageCount);
		int begin = (page-1)*pagesize;
		List<Product> list = productDAO.findWithPage(begin,pagesize);
		pageBean.setProList(list);
		return pageBean;
	}

	public void save(Product product) {
		productDAO.save(product);
	}

	public void delete(Product product) {
		productDAO.delete(product);
	}

	public void update(Product product) {
		productDAO.update(product);
	}

}
