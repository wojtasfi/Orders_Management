package model;

public class Product {
	private String name;
	private int storage;
	private float price;
	
	
	public Product(String name, int storage, float price) {
		super();
		this.name = name;
		this.storage = storage;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStorage() {
		return storage;
	}


	public void setStorage(int storage) {
		this.storage = storage;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
		

}
