package com.qhit.dao;

import java.util.List;

import com.qhit.entity.ProductCategoryVo;

public interface ProductCategoryDao {
	// 获取三级菜单栏
	public List<ProductCategoryVo> getAllProductCategory();
}
