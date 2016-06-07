package cn.itcast.shop.categorysecond.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.itcast.shop.category.model.Category;
import cn.itcast.shop.product.model.Product;

@Entity
public class CategorySecond {
	private Integer csid;
	private String csname;
	private Category category;
	private Set<Product> products = new HashSet<Product>();
	
	@Id
	@GeneratedValue
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="cid")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy="categorySecond",cascade={CascadeType.ALL})
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
