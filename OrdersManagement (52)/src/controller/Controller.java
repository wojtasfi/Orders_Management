package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import gui_clients.ClientEvent;
import gui_orders.FormEvent;
import gui_products.ProductEvent;
import model.Client;
import model.Database;
import model.MostProfitClients;
import model.Order;
import model.Orders;
import model.Product;

public class Controller {

	Database db = new Database();

	public List<Orders> getPeople() {
		return db.getOrders();
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

	public void removeOrder(int index) {
		db.removeOrder(index);
	}

	public void saveOrder() throws SQLException, ParseException {
		db.saveOrder();
	}

	public void disconnect() {
		db.disconnect();
	}

	public void connect() throws Exception {
		db.connect();
	}

	public void loadOrders() throws Exception {
		db.loadOrders();
	}

	public void saveClient(ClientEvent e) throws SQLException {
		String name = e.getName();
		String surname = e.getSurname();
		String street = e.getStreet();
		int number = e.getNumber();
		String zip = e.getZip();
		String city = e.getCity();

		Client client = new Client(name, surname, street, number, zip, city);

		db.saveClient(client);

	}

	public void loadClients() throws SQLException {
		db.loadClients();

	}

	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return db.getClients();
	}

	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return db.getProducts();
	}
	
	public List<MostProfitClients> getMostProfitClients(){
		return db.getMostProfitClients();
		
		
		
	}

	public void saveProduct(ProductEvent ev) throws SQLException {
		String name = ev.getName();
		float price = ev.getPrice();
		int storage = ev.getStorage();

		Product product = new Product(name, storage, price);
		db.saveProduct(product);

	}

	public void loadProducts() throws SQLException {
		db.loadProducts();
	}

	public void loadMostProfitClients() throws SQLException {

		db.loadMostProfitClients();
	}
	
	

}
