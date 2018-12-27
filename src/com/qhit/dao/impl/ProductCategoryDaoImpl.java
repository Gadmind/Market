package com.qhit.dao.impl;

import java.util.List;

import com.qhit.dao.ProductCategoryDao;
import com.qhit.entity.ProductCategoryVo;
import com.qhit.util.BaseUtil;

public class ProductCategoryDaoImpl extends BaseUtil implements ProductCategoryDao {
	public List<ProductCategoryVo> getAllProductCategory() {
		List<ProductCategoryVo> list = TestMenu.get();
		return list;
	}

}
