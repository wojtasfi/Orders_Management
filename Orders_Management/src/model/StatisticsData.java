package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class StatisticsData {

	private ObservableList data;
	private XYChart.Series<Integer, Float> series;
	private Connection con;
	private Database db;

	public StatisticsData() {
		// this.con=con;
		db = new Database();
		buildData();
		buildDataLineChart();

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
				data.add(new PieChart.Data(rs.getString(2), rs.getDouble(1)));

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			return;

		}

	}

	public ObservableList getData() {
		return data;
	}

	public void buildDataLineChart() {
		 series = new XYChart.Series();

		

		try {
			con = db.connect();
			
			String SQL = "SELECT O.LOAD_DTE, SUM(p.PRICE*o.QUANTITY)" + "FROM ORDERS o "
					+ "join products p on o.product = p.name " + "group by O.LOAD_DTE";

			ResultSet rs = con.createStatement().executeQuery(SQL);

			while (rs.next()) {
				
				Date date = rs.getDate(1);
				
				String sDate = date.toString();
				
				

				 series.getData().add(new XYChart.Data(sDate, rs.getFloat(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "ERROR CLOSE");
		}

	}
	
	public XYChart.Series getSeries(){
		return series;
	}

	/*
	 * public void setConnection(Connection con) { // TODO Auto-generated method
	 * stub this.con=con; }
	 */
}
