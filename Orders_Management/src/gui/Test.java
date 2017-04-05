package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Test extends JPanel{
	private JTextField textField;
	private JTable table;
	public Test() {
		
		table = new JTable();
		add(table);
		
		JLabel lblProduct = new JLabel("Product");
		add(lblProduct);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}

}
