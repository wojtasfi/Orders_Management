package gui;

import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;

public class StatisticsPanel extends JPanel {
	private static Controller controller;
	final JFXPanel fxPanel;
	static PieChart pieChart;
	static LineChart lineChart;
	private JLabel label;
	static CategoryAxis xAxis;
    static NumberAxis yAxis;
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	private static ObservableList data;
	
	public StatisticsPanel() {
		// This method is invoked on the EDT thread

		fxPanel = new JFXPanel();
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		
		xAxis.setLabel("Date");
		yAxis.setLabel("Sales amount");
		
		controller = new Controller();
		data = controller.getChartData();
		
		
		//Ta metoda uruchamia JavaFX w swingu
		initFX(fxPanel);
		add(fxPanel);

		

	}

	private static void initFX(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		Scene scene = createScene();
		fxPanel.setScene(scene);
		
	}
	
	
	//to do sceny dodaję różne komponenty

	private static Scene createScene() {
		pieChart = new PieChart();
		lineChart = new LineChart<String, Number>(xAxis, yAxis);
		
		pieChart.setLegendVisible(true);
		pieChart.setAnimated(true);
		pieChart.setLabelsVisible(true);
		
		
		
		pieChart.getData().addAll(controller.getChartData());
		lineChart.getData().add(controller.getSeries());
		

		BorderPane pane = new BorderPane();
		
		pane.setLeft(pieChart);
		pane.setRight(lineChart);
		
		
		Scene scene = new Scene(pane);
		
		
		
		/*
		Text text = new Text();

		text.setX(100);
		text.setY(100);
		text.setFont(new Font(25));
		text.setText("Welcome JavaFX!");
		text.setVisible(true);

		//root.getChildren().add(text);
		//pieChart.setVisible(true);
		*/
		//root.getChildren().add(pieChart);
		
		return (scene);

	}
	
	

}
