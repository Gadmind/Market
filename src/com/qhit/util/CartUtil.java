package com.qhit.util;
/**
 * 购物车工具类
 * @author 杜先森
 *
 */

import com.qhit.entity.Product;

public class CartUtil {
	private Product product;
	private int quantity;
	private float cost;

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = totalCost(product, quantity);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartUtil(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.cost = totalCost(product, quantity);
	}

	public CartUtil() {
		super();
	}

	public float totalCost(Product product, int quantity) {
		float price = product.getPrice();
		float Tcost = price * quantity;
		return Tcost;

	}

}
