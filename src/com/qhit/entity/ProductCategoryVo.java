package com.qhit.entity;

import java.util.List;

public class ProductCategoryVo {
	private ProductCategory productCategory;
	private List<Product> productList;
	private List<ProductCategoryVo> productCategoryVo;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public List<ProductCategoryVo> getProductCategoryVo() {
		return productCategoryVo;
	}

	public void setProductCategoryVo(List<ProductCategoryVo> productCategoryVo) {
		this.productCategoryVo = productCategoryVo;
	}

	public ProductCategoryVo(ProductCategory productCategory, List<Product> productList,
			List<ProductCategoryVo> productCategoryVo) {
		super();
		this.productCategory = productCategory;
		this.productList = productList;
		this.productCategoryVo = productCategoryVo;
	}

	public ProductCategoryVo() {
		super();
	}

}
