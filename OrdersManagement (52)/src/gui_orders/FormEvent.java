package gui;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EventObject;

public class FormEvent extends EventObject {

	private String c_name;
	private String c_surname;
	private String prod_name;
	private int amount;
	private Date deadline;
	
	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}



	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	

	public FormEvent(Object source, String c_name,String c_surname, String prod_name, int amount, Date deadline) {
		super(source);
		this.c_name = c_name;
		this.c_surname = c_surname;
		this.prod_name = prod_name;
		this.amount = amount;
		this.deadline = deadline;
	}

	public String getC_surname() {
		return c_surname;
	}

	public void setC_surname(String c_surname) {
		this.c_surname = c_surname;
	}



	



	
}
