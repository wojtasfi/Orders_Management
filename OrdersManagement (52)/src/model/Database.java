package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

// This is the class which we are going to connect to database and exchange data (this is the root data)
//conntec(), disconnect(), save(), load()
public class Database {

	private Connection con;
	private List<Orders> orders;
	private List<Order> order;
	private List<Client> clients;
	private List<Product> products;

	// Ładuje sql który łączy to wszystko, ale zapisuje tylko do tabeli 'orders'
	public void loadOrders() throws SQLException {
		ArrayList columnNames = new ArrayList();

		orders.clear();

		// To tu muszę zrobić selecta z joinem żeby mi ładnie wyświetlało i po
		// kązdym dodaniu musi zrobic save load i refresh
		String sql = "select o.c_name, o.c_surname, concat(c.street, ' ',c.houseNumber,' ', c.zip, ' ', c.city) as Address, o.product, "
				+ "p.price, o.amount, round(p.price*o.amount,2), o.deadline from orders o "
				+ "join clients c on concat(c.name,c.surname) = concat(o.c_name, o.c_surname) join products p on p.name= o.product";
		Statement selectStatement = con.createStatement();
		ResultSet rs = selectStatement.executeQuery(sql);

		while (rs.next()) {

			// muszę stworzyć nową klasę orders i dać jej konstruktor ze
			// wszytkimi polami co chce wyświetlić
			String c_name = rs.getString(1);
			String c_surname = rs.getString(2);
			String address = rs.getString(3);
			String product = rs.getString(4);
			float price = rs.getFloat(5);
			int quantity = rs.getInt(6);
			float amount = rs.getFloat(7);
			Date deadline = rs.getDate(8);

			Orders newOrder = new Orders(c_name, c_surname, address, product, price, quantity, amount, deadline);
			orders.add(newOrder);

		}

	}

	public void connect() throws Exception {

		// return pozwala na wyjście z metody
		if (con != null)
			return;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}

		String Url = "jdbc:mysql://localhost:3306/OrdersManagement";
		con = DriverManager.getConnection(Url, "root", "pollop123");

	}

	public void disconnect() {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Can`t close connection");
			}
		}
	}

	public void saveOrder() throws SQLException, ParseException {

		// First we check if exists, if true then UPDATE, else INSERT
		// Do not use real values, use ? instead

		String insertSql = "insert into orders (c_name, c_surname, product, amount, deadline) " + "values (?,?,?,?,?)";
		PreparedStatement insertStmt = con.prepareStatement(insertSql);

		for (Order order : order) {

			String c_name = order.getC_name();
			String c_surname = order.getC_surname();
			String prod_name = order.getProd_name();
			int amount = order.getAmount();
			Date deadline = order.getDeadline();

			java.sql.Date sqlDate = new java.sql.Date(deadline.getTime());

			int col = 1;

			insertStmt.setString(col++, c_name);
			insertStmt.setString(col++, c_surname);
			insertStmt.setString(col++, prod_name);
			insertStmt.setInt(col++, amount);
			insertStmt.setDate(col++, sqlDate);

			insertStmt.executeUpdate();

		}

		insertStmt.close();
		order.clear();

	}

	public void saveClient(Client client) throws SQLException {
		String insertSql = "insert into clients (name, surname, street, houseNumber, zip,city) "
				+ "values (?,?,?,?,?,?)";
		PreparedStatement insertStmt = con.prepareStatement(insertSql);

		String name = client.getName();
		String surname = client.getSurname();
		String street = client.getStreet();
		int number = client.getNumber();
		String zip = client.getZip();
		String city = client.getCity();

		int col = 1;

		insertStmt.setString(col++, name);
		insertStmt.setString(col++, surname);
		insertStmt.setString(col++, street);
		insertStmt.setInt(col++, number);
		insertStmt.setString(col++, zip);
		insertStmt.setString(col++, city);

		insertStmt.executeUpdate();

	}

	public Database() {
		order = new LinkedList<Order>();
		orders = new LinkedList<Orders>();
		clients = new LinkedList<Client>();
		products = new LinkedList<Product>();

	}

	public void addOrder(Order orderr) {
		order.add(orderr);

	}

	public List<Orders> getOrders() {
		return Collections.unmodifiableList(orders);
	}
	public List<Client> getClients() {
		return clients;

	}

	public void removeOrder(int index) {
		order.remove(index);
	}

	public void loadClients() throws SQLException {
		
		clients.clear();
		String sql = "select name, surname, street, houseNumber, zip, city from clients";

		Statement selectStatement = con.createStatement();
		ResultSet results = selectStatement.executeQuery(sql);

		while (results.next()) {

			
			String name = results.getString("name");
			String surname = results.getString("surname");
			String street = results.getString("street");
			int number = results.getInt("houseNumber");
			String zip = results.getString("zip");
			String city = results.getString("city");
			

			Client client = new Client(name, surname, street, number, zip,city);
			clients.add(client);

		}

		
		results.close();
		selectStatement.close();
	}

	
public void loadProducts() throws SQLException {
		
		clients.clear();
		String sql = "select name, price, storage from products";

		Statement selectStatement = con.createStatement();
		ResultSet results = selectStatement.executeQuery(sql);

		while (results.next()) {

			
			String name = results.getString("name");
			int price = results.getInt("storage");
			float storage = results.getFloat("price");
			
			

			Product product = new Product(name, price, storage);
			products.add(product);

		}

		
		results.close();
		selectStatement.close();
	}

}
