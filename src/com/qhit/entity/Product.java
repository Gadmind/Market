package com.qhit.entity;

public class Product {

	private int id;//
	private String name;// 名称
	private String description;// 描述
	private float price;// 价格
	private int stock;// 库存
	private int categoryLevel1Id;// 分类1
	private int categoryLevel12d;// 分类2
	private int categoryLevel13d;// 分类3
	private String fileName;// 文件名称
	private int isDelete;// 是否删除(1：删除 0：未删除)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCategoryLevel1Id() {
		return categoryLevel1Id;
	}

	public void setCategoryLevel1Id(int categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}

	public int getCategoryLevel12d() {
		return categoryLevel12d;
	}

	public void setCategoryLevel12d(int categoryLevel12d) {
		this.categoryLevel12d = categoryLevel12d;
	}

	public int getCategoryLevel13d() {
		return categoryLevel13d;
	}

	public void setCategoryLevel13d(int categoryLevel13d) {
		this.categoryLevel13d = categoryLevel13d;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Product(int id, String name, String description, float price, int stock, int categoryLevel1Id,
			int categoryLevel12d, int categoryLevel13d, String fileName, int isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLevel1Id = categoryLevel1Id;
		this.categoryLevel12d = categoryLevel12d;
		this.categoryLevel13d = categoryLevel13d;
		this.fileName = fileName;
		this.isDelete = isDelete;
	}

	public Product() {
		super();
	}

}
