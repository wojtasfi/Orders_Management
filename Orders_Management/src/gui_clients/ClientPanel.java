package gui_clients;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;

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
	
	private Controller controller;

	private ClientListener clientListener;

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

		nameLabel = new JLabel("Name");
		surnameLabel = new JLabel("Surname");
		streetLabel = new JLabel("Street");
		numberLabel = new JLabel("Number");
		zipLabel = new JLabel("Zip");
		cityLabel = new JLabel("City");
		
		controller = new Controller();

		add = new JButton("Add Client");
		
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 String nameC = name.getText();
				 String surnameC= surname.getText();
				 String streetC =street.getText();
				 int numberC = Integer.parseInt(number.getText());
				 String zipC = zip.getText();
				 String cityC = city.getText();
				 
				 ClientEvent ev = new ClientEvent(this, nameC, surnameC, streetC,
						 numberC, zipC, cityC);
				 
				clientListener.clientAdded(ev);
				
			}
			
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Client");

		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		layoutComponents();
		setVisible(true);
	}

	public void setListener(ClientListener listener) {
		this.clientListener = listener;
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

		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(surnameLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(surname, gc);

		///////////////////// Next row///////////////////

		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(streetLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(street, gc);

		///////////////////// Next row///////////////////

		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(numberLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(number, gc);

		///////////////////// Next row///////////////////

		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(zipLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(zip, gc);

		///////////////////// Next row///////////////////

		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(cityLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(city, gc);

		///////////////////// Next row///////////////////

		gc.gridy++;
		gc.gridx = 1;
		gc.weightx = 1;
		gc.weighty = 2;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(add, gc);

	}
}
