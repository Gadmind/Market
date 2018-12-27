package com.qhit.dao;

import java.util.List;

import com.qhit.entity.Product;

public interface ProductDao {

	public List<Product> getProductByParentId(int id);

	public Product getProductById(int id);
}
