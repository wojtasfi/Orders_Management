package gui;

import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ClientEvent extends EventObject {
	
	private String name;
	private String surname;
	private String street;
	private int number;
	private String zip;
	private String city;
	
	
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


	public ClientEvent(Object source, String name, String surname, String street, int number, String zip, String city) {
		super(source);
		this.name = name;
		this.surname = surname;
		this.street = street;
		this.number = number;
		this.zip = zip;
		this.city = city;
	}

	


}
