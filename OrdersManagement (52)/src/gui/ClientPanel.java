package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientPanel extends JPanel {

	private JTextField name;
	private JTextField surname;
	private JTextField street;
	private JTextField number;
	private JTextField zip;
	private JTextField city;
	private JButton add;

	private JLabel nameLabel;
	private JLabel surnameLabel;
	private JLabel streetLabel;
	private JLabel numberLabel;
	private JLabel zipLabel;
	private JLabel cityLabel;

	public ClientPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		setMinimumSize(dim);

		name = new JTextField(10);
		surname = new JTextField(10);
		street = new JTextField(10);
		number = new JTextField(10);
		zip = new JTextField(10);
		city = new JTextField(10);

		JLabel nameLabel = new JLabel("Name");
		JLabel surnameLabel = new JLabel("Surname");
		JLabel streetLabel = new JLabel("Street");
		JLabel numberLabel = new JLabel("Number");
		JLabel zipLabel = new JLabel("Zip");
		JLabel cityLabel = new JLabel("City");

		add = new JButton("Add Client");

		layoutComponents();
		setVisible(true);
	}

	public void layoutComponents() {
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		///////////////////// Next row/////////////////////
		gc.gridy = 0; // top

		// Left-top corner
		gc.gridx = 0; // left

		// How much space it takes COMPARED to other cells
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(name, gc);

		///////////////////// Next row///////////////////
	}
}
