package gui;

import java.util.EventObject;

public class ProductEvent extends EventObject {
	
	private String name;
	private float price;
	private int storage;
	
	
	public ProductEvent(Object source, String name, float price, int storage) {
		super(source);

		this.name = name;
		this.price = price;
		this.storage = storage;
		
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getStorage() {
		return storage;
	}


	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	

}
