package com.qhit.entity;

import java.util.List;

import com.qhit.util.CartUtil;

/**
 * 购物车实体类对象
 * 
 * @author 杜先森
 *
 */
public class Carts {
	private List<CartUtil> items;
	private float sum;

	public List<CartUtil> getItems() {
		return items;
	}

	public void setItems(List<CartUtil> items) {
		this.items = items;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(List<CartUtil> items) {
		this.sum =  amount(items);
	}

	public Carts(List<CartUtil> items) {
		super();
		this.items = items;
		this.sum = amount(items);
	}

	public Carts() {
		super();
	}

	public float amount(List<CartUtil> items) {
		float s = 0;
		for (CartUtil cartUtil : items) {
			float pri=cartUtil.getProduct().getPrice();
			int count=cartUtil.getQuantity();
			s+=pri*count;
		}
		return s;
	}
}
