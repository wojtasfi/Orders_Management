package gui;

import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

public class StatisticsPanel extends JPanel {
	private static Controller controller;
	final JFXPanel fxPanel;
	static PieChart pieChart;
	private JLabel label;
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	private static ObservableList data;
	
	public StatisticsPanel() {
		// This method is invoked on the EDT thread

		fxPanel = new JFXPanel();
		
		controller = new Controller();
		data = controller.getChartData();
		initFX(fxPanel);
		add(fxPanel);
		add(new Label("Hello"));
		setVisible(true);
		

	}

	private static void initFX(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		Scene scene = createScene();
		fxPanel.setScene(scene);
		
	}
	
	

	private static Scene createScene() {
		pieChart = new PieChart();

		

		pieChart.getData().addAll(controller.getChartData());

		Group root = new Group();
		Scene scene = new Scene(pieChart);
		
		
		
		
		
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
	
	public void refresh(){
		fxPanel.revalidate();
		fxPanel.validate();
		//pieChart.resize(300, 300);
		
	}

}
