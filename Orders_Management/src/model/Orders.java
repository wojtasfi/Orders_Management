package model;

import java.util.Date;

public class Orders {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	private String c_name;
	private String c_surname;
	private String address;
	private String product;
	private float price;
	private int quantity;
	private float amount;
	private Date deadline;
	
	
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Orders(int id, String c_name, String c_surname, String address, String product, float price, int quantity,
			float amount, Date deadline) {
		super();
		this.id = id;
		this.c_name = c_name;
		this.c_surname = c_surname;
		this.address = address;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.deadline = deadline;
	}
	public Orders(String c_name, String c_surname, String address, String product, float price, int quantity,
			float amount, Date deadline) {
		super();
		this.c_name = c_name;
		this.c_surname = c_surname;
		this.address = address;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.deadline = deadline;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_surname() {
		return c_surname;
	}
	public void setC_surname(String c_surname) {
		this.c_surname = c_surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
