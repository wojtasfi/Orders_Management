package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class StatisticsData {

	private ObservableList data;
	private Connection con;
	private Database db;

	
	public StatisticsData() {
		//this.con=con;
		db = new Database();
		buildData();
		
	}
	public ObservableList getChartData() {
		return data;
		
	}
	

	public void buildData() {


		data = FXCollections.observableArrayList();

		try {

			// c = DBConnect.connect();

			// SQL FOR SELECTING NATIONALITY OF CUSTOMER
			
			con = db.connect();

			String SQL = "SELECT COUNT(id), "

					+ "name FROM Clients group by name";

			ResultSet rs = con.createStatement().executeQuery(SQL);

			while (rs.next()) {

				// adding data on piechart data
				
				System.out.println(rs.getDouble(1));

				data.add(new PieChart.Data(rs.getString(2), rs.getDouble(1)));

			}

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error on DB connection");

			return;

		}

	}
	
	public ObservableList getData(){
		return data;
	}
	
	


/*
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con=con;
	}
*/
}
