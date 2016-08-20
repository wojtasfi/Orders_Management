package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import gui.FormEvent;
import model.Database;
import model.Order;
import model.Orders;

public class Controller {

	Database db = new Database();

	public List<Orders> getPeople() {
		return db.getPeople();
	}

	public void addPerson(FormEvent ev) {
		String c_name = ev.getC_name();
		String c_surname = ev.getC_surname();
		String prod_name = ev.getProd_name();
		int amount = ev.getAmount();
		Date deadline = ev.getDeadline();

		Order order = new Order(c_name, c_surname, prod_name, amount, deadline);

		db.addOrder(order);
	}

	public void removePerson(int index) {
		db.removeOrder(index);
	}

	public void save() throws SQLException, ParseException {
		db.save();
	}

	public void disconnect() {
		db.disconnect();
	}

	public void connect() throws Exception {
		db.connect();
	}

	public void load() throws Exception {
		db.load();
	}
}
