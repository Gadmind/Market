package com.qhit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.dao.ProductDao;
import com.qhit.entity.ProductCategory;
import com.qhit.entity.ProductCategoryVo;
import com.qhit.util.BaseUtil;

public class TestMenu extends BaseUtil {
	/**
	 * 获取Type为1的商品
	 * 
	 * @param type
	 * @return
	 */
	public List<ProductCategory> getProById(int type) {
		String sql = "SELECT * FROM easybuy_product_category WHERE type=?";
		Object[] params = { type };
		ResultSet rs = Select(sql, params);
		List<ProductCategory> plist = new ArrayList<ProductCategory>();
		try {
			while (rs.next()) {
				ProductCategory epc = new ProductCategory(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5));
				plist.add(epc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plist;
	}

	/**
	 * 通过parentId来获取和type为1相等的id
	 * 
	 * @param parentId
	 * @return
	 */
	public List<ProductCategory> getProByParentId(int parentId) {
		String sql = "SELECT * FROM easybuy_product_category WHERE parentId=?";
		Object[] params = { parentId };
		ResultSet rs = Select(sql, params);
		List<ProductCategory> plist = new ArrayList<ProductCategory>();
		try {
			while (rs.next()) {
				ProductCategory epc = new ProductCategory(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5));
				plist.add(epc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plist;
	}

	/**
	 * 一次性获取三级菜单栏
	 * 
	 * @return
	 */
	public static List<ProductCategoryVo> get() {
		TestMenu tm = new TestMenu();
		ProductDao pd = new ProductDaoImpl();
		List<ProductCategoryVo> pc = new ArrayList<ProductCategoryVo>();
		List<ProductCategory> list1 = tm.getProById(1);
		for (int i = 0; i < list1.size(); i++) {
			ProductCategoryVo p = new ProductCategoryVo();
			p.setProductCategory(list1.get(i));
			List<ProductCategoryVo> ps1 = new ArrayList<ProductCategoryVo>();
			List<ProductCategory> list2 = tm.getProByParentId(list1.get(i).getId());
			for (int j = 0; j < list2.size(); j++) {
				ProductCategoryVo p1 = new ProductCategoryVo();
				p1.setProductCategory(list2.get(j));
				List<ProductCategoryVo> ps2 = new ArrayList<ProductCategoryVo>();
				List<ProductCategory> list3 = tm.getProByParentId(list2.get(j).getId());
				for (int k = 0; k < list3.size(); k++) {
					ProductCategoryVo p2 = new ProductCategoryVo();
					p2.setProductCategory(list3.get(k));
					ps2.add(p2);
				}
				p1.setProductCategoryVo(ps2);
				ps1.add(p1);
			}
			p.setProductList(pd.getProductByParentId(list1.get(i).getId()));
			p.setProductCategoryVo(ps1);
			pc.add(p);
		}
		return pc;
	}
}
