package com.qhit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.dao.ProductDao;
import com.qhit.entity.Product;
import com.qhit.util.BaseUtil;

public class ProductDaoImpl extends BaseUtil implements ProductDao {
	public List<Product> getProductByParentId(int id) {
		String sql = "SELECT * FROM EASYBUY_PRODUCT where CategoryLevel1Id = ?";
		Object[] params = { id };
		ResultSet rs = Select(sql, params);
		List<Product> plist = new ArrayList<Product>();
		try {
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
				plist.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plist;
	}

	public Product getProductById(int id) {
		String sql = "SELECT * FROM EASYBUY_PRODUCT WHERE ID=?";
		Object[] params = { id };
		ResultSet rs = Select(sql, params);
		Product p = null;
		try {
			while (rs.next()) {
				p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
