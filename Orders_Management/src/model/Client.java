package model;

import javax.swing.JTextField;

public class Client {
	
	private int id;
	private String name;
	private String surname;
	private String street;
	private int number;
	private String zip;
	private String city;
	
	
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Client(String name, String surname, String street, int number, String zip, String city) {
		super();
		this.name = name;
		this.surname = surname;
		this.street = street;
		this.number = number;
		this.zip = zip;
		this.city = city;
	}
	
	public Client(int id,String name, String surname, String street, int number, String zip, String city) {
		super();
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.street = street;
		this.number = number;
		this.zip = zip;
		this.city = city;
	}

}
